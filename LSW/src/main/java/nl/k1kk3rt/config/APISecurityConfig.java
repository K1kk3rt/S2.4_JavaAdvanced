package nl.k1kk3rt.config;

import nl.k1kk3rt.filter.APIKeyAuthFilter;
import nl.k1kk3rt.repository.ApiKeyRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
@Order(2)
public class APISecurityConfig extends WebSecurityConfigurerAdapter {

    private ApiKeyRepository apiKeyRepository;

    @Value("X-AUTHTOKEN")
    private String headerName;

    public  APISecurityConfig(ApiKeyRepository apiKeyRepository) {
        this.apiKeyRepository = apiKeyRepository;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user")
                .password("password")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("password")
                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        APIKeyAuthFilter filter = new APIKeyAuthFilter(headerName);
        filter.setAuthenticationManager(authentication -> {
            String principal = (String) authentication.getPrincipal();

            if (!apiKeyRepository.findById(principal).isPresent()) {
                throw new BadCredentialsException("API Key was not found on the system");
            }
            authentication.setAuthenticated(true);
            return authentication;
        });


        httpSecurity.csrf().disable();
        httpSecurity.authorizeRequests()
                .antMatchers("/").permitAll()// Everybody can see root
                .antMatchers(HttpMethod.GET, "/points/**").hasRole("ADMIN") // Only Admin can GET
                .antMatchers(HttpMethod.POST, "/points/**").hasRole("ADMIN") // Only Admin can POST
                .antMatchers(HttpMethod.DELETE, "/points/**").hasRole("ADMIN") // Only Admin can DELETE
                .antMatchers(HttpMethod.GET, "/patrols/**").permitAll() // All users can GET
                .antMatchers(HttpMethod.POST, "/patrols/**").hasRole("ADMIN") // Only Admin can POST
                .antMatchers(HttpMethod.DELETE, "/patrols/**").hasRole("ADMIN") // Only Admin can DELETE
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll(); // The login page can be seen by everybody
    }
}


package nl.k1kk3rt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password("{noop}password")
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password("{noop}password")
//                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.authorizeRequests()
//                .antMatchers("/").permitAll()// Everybody can see root
//                .antMatchers(HttpMethod.GET, "/points/**").hasRole("ADMIN") // Only Admin can GET
//                .antMatchers(HttpMethod.POST, "/points/**").hasRole("ADMIN") // Only Admin can POST
//                .antMatchers(HttpMethod.DELETE, "/points/**").hasRole("ADMIN") // Only Admin can DELETE
//                .antMatchers(HttpMethod.GET,"/patrols/**").permitAll() // All users can GET
//                .antMatchers(HttpMethod.POST,"/patrols/**").hasRole("ADMIN") // Only Admin can POST
//                .antMatchers(HttpMethod.POST,"/DELETE/**").hasRole("ADMIN") // Only Admin can DELETE
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().permitAll(); // The login page can be seen by everybody
    }
}


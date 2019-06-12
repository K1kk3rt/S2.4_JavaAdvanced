package nl.k1kk3rt.service;

import nl.k1kk3rt.model.ApiKey;
import nl.k1kk3rt.repository.ApiKeyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SecurityService {

    ApiKeyRepository apiKeyRepository;
    ArrayList<ApiKey> keys;


    public SecurityService(ApiKeyRepository apiKeyRepository){
        this.apiKeyRepository = apiKeyRepository;

        keys = new ArrayList<ApiKey>();

        keys.add(new ApiKey("123456789"));
        keys.add(new ApiKey("987654321"));

        this.saveKeys();
    }

    private void saveKeys(){
        keys.stream()
                .forEach(key -> apiKeyRepository.save(key));

        apiKeyRepository.findAll()
                .forEach(System.out::println);
    }
}

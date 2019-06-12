package nl.k1kk3rt.repository;

import nl.k1kk3rt.model.ApiKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiKeyRepository extends CrudRepository<ApiKey, String> {
}


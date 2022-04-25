package acme.features.any;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Configuration;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyConfigurationRepository extends AbstractRepository {
	
	@Query("select c from Configuration c")
	Configuration findConfiguration();
}

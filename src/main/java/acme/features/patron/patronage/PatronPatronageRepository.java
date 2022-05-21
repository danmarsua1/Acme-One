package acme.features.patron.patronage;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Configuration;
import acme.entities.patronage.Patronage;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface PatronPatronageRepository extends AbstractRepository {

	@Query("select patronage from Patronage patronage where patronage.id = :id")
	Patronage findOnePatronageById(int id);

	@Query("select patronage from Patronage patronage where patronage.patron.id = :id")
	Collection<Patronage> findPatronagesByPatronId(int id);

	@Query("select patronage from Patronage patronage where patronage.code like :code")
	Patronage findOnePatronageByCode(String code);
	
	@Query("select configuration from Configuration c")
	Configuration findConfiguration();
}
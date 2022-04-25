package acme.features.inventor.patronageReports;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronage.PatronageReport;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorPatronageReportRepository extends AbstractRepository {

	@Query("select patronageReport from PatronageReport patronageReport where patronageReport.id = :id")
	PatronageReport findOnePatronageReportById(int id);
	
	@Query("select patronageReport from PatronageReport patronageReport where patronageReport.patronage.inventor.id = :id")
	Collection<PatronageReport> findManyPatronageReportsByInventorId(int id);
}

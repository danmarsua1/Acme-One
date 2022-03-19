package acme.forms.patron;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface PatronDashboardRepository extends AbstractRepository {

	// Manage TOTALS
	@Query("select count(p) from Patronage p where p.status LIKE '%PROPOSED%'")
	Integer totalNumberOfProposedPatronages();

	@Query("select count(p) from Patronage p where p.status LIKE '%ACCEPTED%'")
	Integer totalNumberOfAcceptedPatronages();

	@Query("select count(p) from Patronage p where p.status LIKE '%DENIED%'")
	Integer totalNumberOfDeniedPatronages();

	// Manage PROPOSED
	@Query("select avg(p.budget) from Patronage p where p.status LIKE '%PROPOSED%'")
	Double averageBudgetOfProposedPatronages();

	@Query("select stdev(p.budget) from Patronage p where p.status LIKE '%PROPOSED%'")
	Double deviationBudgetOfProposedPatronages();

	@Query("select min(p.budget) from Patronage p where p.status LIKE '%PROPOSED%'")
	Double minimumBudgetOfProposedPatronages();

	@Query("select max(p.budget) from Patronage p where p.status LIKE '%PROPOSED%'")
	Double maximumBudgetOfProposedPatronages();

	// Manage ACCEPTED
	@Query("select avg(p.budget) from Patronage p where p.status LIKE '%ACCEPTED%'")
	Double averageBudgetOfAcceptedPatronages();

	@Query("select stdev(p.budget) from Patronage p where p.status LIKE '%ACCEPTED%'")
	Double deviationBudgetOfAcceptedPatronages();

	@Query("select min(p.budget) from Patronage p where p.status LIKE '%ACCEPTED%'")
	Double minimumBudgetOfAcceptedPatronages();

	@Query("select max(p.budget) from Patronage p where p.status LIKE '%ACCEPTED%'")
	Double maximumBudgetOfAcceptedPatronages();

	// Manage DENIED
	@Query("select avg(p.budget) from Patronage p where p.status LIKE '%DENIED%'")
	Double averageBudgetOfDeniedPatronages();

	@Query("select stdev(p.budget) from Patronage p where p.status LIKE '%DENIED%'")
	Double deviationBudgetOfDeniedPatronages();

	@Query("select min(p.budget) from Patronage p where p.status LIKE '%DENIED%'")
	Double minimumBudgetOfDeniedPatronages();

	@Query("select max(p.budget) from Patronage p where p.status LIKE '%DENIED%'")
	Double maximumBudgetOfDeniedPatronages();
	
}
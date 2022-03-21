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
	@Query("select avg(p.budget.quantity) from Patronage p where p.status LIKE '%PROPOSED%' group by p.budget.currency")
	Double averageBudgetOfProposedPatronages();

	@Query("select stdev(p.budget.quantity) from Patronage p where p.status LIKE '%PROPOSED%' group by p.budget.currency")
	Double deviationBudgetOfProposedPatronages();

	@Query("select min(p.budget.quantity) from Patronage p where p.status LIKE '%PROPOSED%' group by p.budget.currency")
	Double minimumBudgetOfProposedPatronages();

	@Query("select max(p.budget.quantity) from Patronage p where p.status LIKE '%PROPOSED%' group by p.budget.currency")
	Double maximumBudgetOfProposedPatronages();

	// Manage ACCEPTED
	@Query("select avg(p.budget.quantity) from Patronage p where p.status LIKE '%ACCEPTED%' group by p.budget.currency")
	Double averageBudgetOfAcceptedPatronages();

	@Query("select stdev(p.budget.quantity) from Patronage p where p.status LIKE '%ACCEPTED%' group by p.budget.currency")
	Double deviationBudgetOfAcceptedPatronages();

	@Query("select min(p.budget.quantity) from Patronage p where p.status LIKE '%ACCEPTED%' group by p.budget.currency")
	Double minimumBudgetOfAcceptedPatronages();

	@Query("select max(p.budget.quantity) from Patronage p where p.status LIKE '%ACCEPTED%' group by p.budget.currency")
	Double maximumBudgetOfAcceptedPatronages();

	// Manage DENIED
	@Query("select avg(p.budget.quantity) from Patronage p where p.status LIKE '%DENIED%' group by p.budget.currency")
	Double averageBudgetOfDeniedPatronages();

	@Query("select stdev(p.budget.quantity) from Patronage p where p.status LIKE '%DENIED%' group by p.budget.currency")
	Double deviationBudgetOfDeniedPatronages();

	@Query("select min(p.budget.quantity) from Patronage p where p.status LIKE '%DENIED%' group by p.budget.currency")
	Double minimumBudgetOfDeniedPatronages();

	@Query("select max(p.budget.quantity) from Patronage p where p.status LIKE '%DENIED%' group by p.budget.currency")
	Double maximumBudgetOfDeniedPatronages();
	
}
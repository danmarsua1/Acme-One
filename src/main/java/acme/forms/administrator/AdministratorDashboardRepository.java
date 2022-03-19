package acme.forms.administrator;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	// Manage COMPONENTS
	@Query("select count(c) from Component c")
	Integer totalNumberOfComponents();

	@Query("select avg(c.retailPrice) from Component c grouped by c.technology")
	Integer averageRetailPriceOfComponents();

	@Query("select stdev(c.retailPrice) from Component c grouped by c.technology")
	Integer deviationRetailPriceOfComponents();
	
	@Query("select min(c.retailPrice) from Component c grouped by c.technology")
	Integer minimumRetailPriceOfComponents();

	@Query("select max(c.retailPrice) from Component c grouped by c.technology")
	Integer maximumRetailPriceOfComponents();
	
	// Manage TOOLS
	@Query("select count(t.retailPrice) from Tool t")
	Integer totalNumberOfTools();
	
	@Query("select avg(t.retailPrice) from Tool t")
	Integer averageRetailPriceOfTools();

	@Query("select stdev(t.retailPrice) from Tool t")
	Integer deviationRetailPriceOfTools();

	@Query("select min(t.retailPrice) from Tool t")
	Integer minimumRetailPriceOfTools();
	
	@Query("select max(t.retailPrice) from Tool t")
	Integer maximumRetailPriceOfTools();
	
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
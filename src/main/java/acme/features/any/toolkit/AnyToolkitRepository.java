package acme.features.any.toolkit;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Toolkit;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyToolkitRepository extends AbstractRepository{

	
	@Query("select t from Toolkit t where t.publish=true")
	Collection<Toolkit> findToolkitPublicado();

	@Query("select t from Toolkit t where t.id = :id")
	Toolkit findOneToolkitById(int id);

	/*@Query("select q.toolkit from Quantity q where q.item.id = :item.id")
	Collection<Toolkit> findToolkitByItem(int id);*/

	
	/*@Query("select sum(q.item.retailPrice.amount*q.amount) from Quantity q where q.toolkit.id=:id")
	Money toolkitPrice(int id);*/



}

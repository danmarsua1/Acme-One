/*
 * InventorItemRepository.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.inventor.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Item;
import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorItemRepository extends AbstractRepository {

	@Query("select ua from UserAccount ua where ua.id = :id")
	UserAccount findOneUserAccountById(int id);

	@Query("select i from Item i where i.inventor.id = :id")
	Collection<Item> findManyItemsByInventor(int id);
	
	@Query("select i from Item i where i.id = :id")
	Item findOneItemById(int id);

	@Query("select i from Toolkit t, Quantity q, Item i where t.id = q.toolkit.id and q.item.id = i.id and t.id = :toolkitId and i.inventor.id = :inventorId")
	Collection<Item> findManyItemsByToolkitIdAndInventorId(int toolkitId, int inventorId);
	
	

}

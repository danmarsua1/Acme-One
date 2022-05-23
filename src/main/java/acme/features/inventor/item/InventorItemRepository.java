package acme.features.inventor.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Item;
import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface InventorItemRepository extends AbstractRepository {

	@Query("SELECT userAccount FROM UserAccount userAccount WHERE userAccount.id = :id")
	UserAccount findOneUserAccountById(int id);

	@Query("SELECT item FROM Item item WHERE item.inventor.id = :id")
	Collection<Item> findManyItemsByInventor(int id);
	
	@Query("SELECT inventor FROM Inventor inventor WHERE inventor.id = :id")
	Inventor findOneInventorById(int id);
	
	@Query("SELECT item FROM Item item WHERE item.id = :id")
	Item findOneItemById(int id);

	@Query("SELECT item FROM Toolkit toolkit, Quantity quantity, Item item WHERE toolkit.id = quantity.toolkit.id AND quantity.item.id = item.id AND toolkit.id = :toolkitId AND item.inventor.id = :inventorId")
	Collection<Item> findManyItemsByToolkitIdAndInventorId(int toolkitId, int inventorId);
	
	@Query("SELECT item FROM Item item WHERE item.inventor.id = :id AND item.type = 'COMPONENT'")
	Collection<Item> findComponentsByInventorId(int id);
	
	@Query("SELECT item FROM Item item WHERE item.inventor.id = :id AND item.type = 'TOOL'")
	Collection<Item> findToolsByInventorId(int id);
	
	@Modifying
	@Query("DELETE FROM Quantity quantity WHERE quantity.item.id = :id")
	void deleteQuantityByItemId(int id);
}
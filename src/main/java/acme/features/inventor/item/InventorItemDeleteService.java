package acme.features.inventor.item;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Inventor;

@Service
public class InventorItemDeleteService implements AbstractDeleteService<Inventor, Item> {

	@Autowired
	protected InventorItemRepository repository;
			
	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;
		boolean result;
		int id;
		Item item;
//		Inventor inventor;

		id = request.getModel().getInteger("id");
		item = this.repository.findOneItemById(id);
//		inventor = item.getInventor();
//		result = !item.isPublished() && request.isPrincipal(inventor);
		result = request.getPrincipal().getActiveRoleId() == item.getInventor().getId();

		return result;
	}
	
	@Override
	public void bind(final Request<Item> request, final Item entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "type", "name", "code", "technology", "description", "retailPrice", "link", "published");
	}
	
	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "type", "name", "code", "technology", "description", "retailPrice", "link", "published");
	}
	
	@Override
	public Item findOne(final Request<Item> request) {
		assert request != null;
		Item result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneItemById(id);

		return result;
	}
	
	@Override
	public void validate(final Request<Item> request, final Item entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}
	
	@Override
	public void delete(final Request<Item> request, final Item entity) {
		assert request != null;
		assert entity != null;
		
		final Collection<Item> i;  //Adaugat
		i = this.repository.findManyItemsByInventor(entity.getId());  //Adaugat
		for (final Item item : i) {  //Adaugat
			this.repository.delete(item);  //Adaugat
		}  //Adaugat
		this.repository.delete(entity);
	}  
}
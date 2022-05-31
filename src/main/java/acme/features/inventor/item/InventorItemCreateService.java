package acme.features.inventor.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.entities.ItemType;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorItemCreateService implements AbstractCreateService<Inventor, Item> {
	
	@Autowired
	protected InventorItemRepository repository;
	
	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;
//		request.getModel();
//		return true;
		boolean result;
		result = request.getPrincipal().hasRole(Inventor.class);
		return result;
	}

	@Override
	public void bind(final Request<Item> request, final Item entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		 
//		entity.setPublished(false);
		request.bind(entity, errors, "type", "name", "code", "technology", "description", "retailPrice", "link");
	}

	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "type", "name", "code", "technology", "description", "retailPrice", "link", "published");		
	}
	
	@Override
	public Item instantiate(final Request<Item> request) {
		assert request != null;
		
		Item result;
		Inventor inventor;
		
		inventor = this.repository.findOneInventorById(request.getPrincipal().getActiveRoleId());		
		result = new Item();
		final ItemType type = ItemType.valueOf((String)request.getModel().getAttribute("type"));
		result.setType(type);
		result.setInventor(inventor);
		
		return result;
	}
	
	@Override
	public void validate(final Request<Item> request, final Item entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;			
	}
			
	@Override
	public void create(final Request<Item> request, final Item entity) {
		assert request != null;
		assert entity != null;
		final ItemType type = ItemType.valueOf((String)request.getModel().getAttribute("type"));
		entity.setType(type);
		entity.setPublished(false);
		this.repository.save(entity);			
	}
}
package acme.features.inventor.item;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Item;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorItemController extends AbstractController<Inventor, Item> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorItemListService listService;

	@Autowired
	protected InventorItemShowService showService;
	
    @Autowired
	protected InventorComponentListService listComponentService;
	
	@Autowired
	protected InventorComponentShowService showComponentService;
	
	@Autowired
	protected InventorComponentCreateService createComponentService;
	
	@Autowired
	protected InventorComponentUpdateService updateComponentService;
	
	@Autowired
	protected InventorComponentDeleteService deleteComponentService;
	
	@Autowired
	protected InventorItemPublishService publishItemService;

	// Constructors -----------------------------------------------------------

	@PostConstruct
	protected void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);
		super.addCommand("create-component", "create", this.createComponentService);
		super.addCommand("update-component", "update", this.updateComponentService);
		super.addCommand("delete-component", "delete", this.deleteComponentService);
		super.addCommand("publish", "update", this.publishItemService);
		super.addCommand("list-component","list", this.listComponentService);
		super.addCommand("show-component","show", this.showComponentService);
	}
}
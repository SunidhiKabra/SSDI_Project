package api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDao;
import model.Item;
import service.ItemService;

//@RequestMapping("/university/rental")
public class ItemController extends HttpServlet{
	private ItemService item_service;
	private Item item;
	
	public ItemController() {
		
	}

	public ItemController(ItemService item_service) {
		super();
		this.item_service = item_service;
	}
	
	public Item createNewItem() {
		item = new Item();
		return item;
	}

	public List<Item> getItem(){
		return item_service.getItem();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		
		Item i = new Item();
		ItemDao iDao = new ItemDao();
		i.setItemName(req.getParameter("itemName"));
		i.setItemDescription(req.getParameter("itemDescription"));
		i.setItemRent(req.getParameter("itemRent"));
		System.out.println("item sent to dao");
		iDao.addItem(i);
		System.out.println("item received from dao");
	}
	

}

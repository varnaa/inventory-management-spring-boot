package com.swetha.varnaa.stockManagement.Controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.swetha.varnaa.stockManagement.model.Item;
import com.swetha.varnaa.stockManagement.model.ItemService;
import com.swetha.varnaa.stockManagement.model.Order;
import com.swetha.varnaa.stockManagement.model.OrderService;

@Controller

public class MainController {

	@Autowired
	private ItemService service;
	
	@Autowired 
	private OrderService orderService;
	
	@GetMapping("/navbar")
	public String getNavbar() {
		return "navbar";
	}
	
	@GetMapping({"/allitems","/"})
	public String getAllitems(Model model) {
		model.addAttribute("items", service.findAll());
		return "allitems";
	}
	
	@GetMapping("/allorders")
	public String getAllorders(Model model) {
		model.addAttribute("orders",orderService.findAll());
		return "allorders";
	}
	
	@GetMapping("/newitem")
	public String getNewitem(Model model) {
		model.addAttribute("item",new Item());
		return "newitem";
	}
		
	@GetMapping("/neworder")
	public String newOrder(Model model) {
		model.addAttribute("order",new Order());
		model.addAttribute("items",service.findAll());
		return "order";
	}
	
	@GetMapping("/saveitem")
	public String saveItem(@ModelAttribute("item") Item item , Model model) {
		service.saveItem(item);
		model.addAttribute("items",service.findAll());
		return "allitems";
		
	}
	
	@GetMapping("/saveorder")
	public String saveOrder(@ModelAttribute("order") Order order, RedirectAttributes redirectAttribute, Model model) {
		order.setOrderCreatedOn(new Date());
		Item item = service.findOne(order.getItem_id());
		System.out.println(item);
		
		int current_stock = item.getCurrent_stock();
		System.out.println(current_stock);
		
		int quantity = order.getQuantity();
		System.out.println(quantity);
		
		if(quantity <= current_stock) {
			current_stock-=quantity;
			System.out.println("after reducing: " + current_stock);
			
			item.setCurrent_stock(current_stock);
			
			service.saveItem(item);
			orderService.saveOrder(order);
			model.addAttribute("order",orderService.findAll());
			model.addAttribute("success","Order created successfully!");
			model.addAttribute("alertClass","alert-sucess");
			return "allorders";
		}
		
		else {
			model.addAttribute("error","Error Quantity can not be greater than current stock! ");
			model.addAttribute("alertClass", "alert-danger");
			model.addAttribute("order",orderService.getByID(order.getOrderID()));
			return "order";
			
		}
	}
}

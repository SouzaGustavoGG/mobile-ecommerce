package app.mobile.ecommerce.ecommerce.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@RequestMapping(method=RequestMethod.GET, value="/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Order>> getOrders(@PathVariable("id") Integer id){
		return new ResponseEntity<>(orderService.doGetByUser(id), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> postOrder(@RequestBody Order form){
		orderService.doPost(form);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<Void> deleteOrder(@PathVariable("id") Integer id){
		orderService.doDelete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}

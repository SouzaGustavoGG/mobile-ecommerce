package app.mobile.ecommerce.ecommerce.order;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.mobile.ecommerce.ecommerce.Http;
import app.mobile.ecommerce.ecommerce.user.User;
import app.mobile.ecommerce.ecommerce.user.UserRepository;

@Service
public class OrderService implements Http<Order,Integer> {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<Order> doGet() {
		List<Order> orders = new ArrayList<>();
		orderRepository.findAll().forEach(orders::add);
		return orders;
	}

	@Override
	public Order doGet(Integer k) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * retorna pedidos do usuario x
	 * @param userId
	 * @return
	 */
	public List<Order> doGetByUser(Integer userId){
		Optional<User> user = userRepository.findById(userId);
		
		List<Order> orders = new ArrayList<>();
		
		if(user.isPresent()){
			orderRepository.findByUser(user.get()).forEach(orders::add);
		}
		
		return orders;
	}

	@Override
	public void doPost(Order e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doPut(Integer k, Order e) {
		Optional<Order> order = orderRepository.findById(k);
		if(order.isPresent()){
			order.get().setUser(e.getUser());
			order.get().setItems(e.getItems());
			
			orderRepository.save(order.get());
		}
		
	}

	@Override
	public void doDelete(Integer k) {
		Optional<Order> order = orderRepository.findById(k);
		if(order.isPresent()){

			Date createTime = order.get().getCreateDate();
			Date nowTime = Calendar.getInstance().getTime();
			long diff = nowTime.getTime() - createTime.getTime();
			int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
			
			if(diffDays <= 3){
				orderRepository.deleteById(k);
			}
		}
	}
}

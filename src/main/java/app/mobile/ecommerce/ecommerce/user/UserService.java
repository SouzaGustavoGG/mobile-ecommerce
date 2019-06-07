package app.mobile.ecommerce.ecommerce.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.mobile.ecommerce.ecommerce.Http;

@Service
public class UserService implements Http<User,Integer>{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> doGet() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
	
	@Override
	public User doGet(Integer k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doPost(User e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * atualiza endereco
	 */
	@Override
	public void doPut(Integer k, User e) {
		Optional<User> user = userRepository.findById(k);
		if(user.isPresent()){
			user.get().setAddress(e.getAddress());
			userRepository.save(user.get());
		}
	}

	@Override
	public void doDelete(Integer k) {
		// TODO Auto-generated method stub	
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}

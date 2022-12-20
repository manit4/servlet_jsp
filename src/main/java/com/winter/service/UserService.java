package com.winter.service;
import com.winter.repository.UserRepository;
import com.winter.to.UserTO;

public class UserService {
	
	public void addUser(UserTO to) {
		
		UserRepository repository = new UserRepository();
		
		repository.saveuser(to);
		
	}

}

package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.model.User;
import com.app.service.IUserService;


@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao ob;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional
	public int saveUser(User user) {
		// TODO Auto-generated method stub
		String pwd=user.getUserPwd();
		//encode password
		pwd=encoder.encode(pwd);
		//set back to model object
		user.setUserPwd(pwd);
		return ob.saveUser(user); 
	}
 
	@Transactional(readOnly=true)
	public User getUserByEmail(String userEmail) { 
		return ob.getUserByEmail(userEmail);
	}

}

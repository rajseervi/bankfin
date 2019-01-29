package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUserDao; 
import com.app.model.User;

@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveUser(User user) {
		// TODO Auto-generated method stub
		return (int) ht.save(user);
	}

	 
 
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public User getUserByEmail(String userEmail) {
		User user=null;
		String hql="from "+User.class.getName()+" where userEmail=?";
		List<User> userList=(List<User>) ht.find(hql, userEmail);
		if(userList!=null && userList.size()>0) {
			user=userList.get(0);
		}
		return user;
	}

}

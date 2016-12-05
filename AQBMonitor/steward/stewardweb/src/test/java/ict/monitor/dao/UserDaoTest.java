package ict.monitor.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ict.monitor.bean.User;
import junit.framework.Assert;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class UserDaoTest {
	@Autowired
	private UserDao userDao;

	@Test
	public void findAllTest() {
		Assert.assertTrue(userDao.findAll().size()!=0);
	}
	
	@Test
	public void findUserByUserNameAndPasswordTest() {
		User user = new User();
		user.setPassword("admin");
		user.setUsername("admin");
		User userFind = userDao.findUserByUserNameAndPassword(user);
		Assert.assertTrue(userFind.getUsername().equals("admin"));
	}
}

package ict.monitor.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ict.monitor.bean.User;

@Repository
@Transactional
public interface UserDao extends BaseDao<User>{

	public List<User> findAll();
	public User findUserByUserNameAndPassword(User user);
	public User findUserByUserName(String username);
	public User findUserByUserEmail(String email);
}

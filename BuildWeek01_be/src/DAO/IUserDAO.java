package DAO;

import java.util.List;

import models.User;

public interface IUserDAO {

	public void save(User u);
	void delete(Long id);
	
	public User getById(Long id);
	public void update(User e);
	public List<User> getAll();

}


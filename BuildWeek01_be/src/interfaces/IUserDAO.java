package interfaces;

import java.util.List;

import models.User;

public interface IUserDAO {
	public void save(User user);

	public void saveAll(List<User> users);

	void delete(Long id);

	public void update(User user);

	public List<User> getAll();
	User getById(long id);

}

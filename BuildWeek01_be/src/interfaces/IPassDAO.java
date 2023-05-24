package interfaces;

import models.Pass;
import models.User;

public interface IPassDAO {
	public User getById(int id);
}

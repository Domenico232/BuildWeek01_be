package interfaces;

import java.util.List;

import models.Pass;

public interface IPassDAO {
	
	public void save(Pass r);
	void delete(long id);
	public Pass getById(long id);
	public void update(Pass e);
	public List<Pass> getAll();
}

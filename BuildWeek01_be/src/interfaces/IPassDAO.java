package interfaces;

import java.util.List;

import models.Pass;

public interface IPassDAO {
	
	public void save(Pass r);
	void delete(Long id);
	public Pass getById(Long id);
	public void update(Pass e);
	public List<Pass> getAll();
}

package DAO;

import java.util.List;
import models.Reseller;

public interface IResellerDAO {

	public void save(Reseller r);
	void delete(Long id);
	public Reseller getById(Long id);
	public void update(Reseller e);
	public List<Reseller> getAll();
}

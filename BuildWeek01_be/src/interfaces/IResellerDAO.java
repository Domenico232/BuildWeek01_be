package interfaces;

import java.util.List;
import models.Reseller;

public interface IResellerDAO {

	public void save(Reseller r);
	void delete(long id);
	public Reseller getById(long id);
	public void update(Reseller e);
	public List<Reseller> getAll();
}

package interfaces;

import java.util.List;

import models.Trace;
import models.Veicle;



public interface IVeicleDAO {

	public void save(Veicle u);
	void delete(Long id);
	public Veicle getById(Long id);
	public void update(Veicle e);
	public List<Veicle> getAll();

}

package interfaces;

import java.util.List;

import models.Veicle;



public interface IVeicleDAO {

	public void save(Veicle u);
	void delete(Long id);
	public Veicle getById(Long id);
	public void update(Veicle e);
	public List<Veicle> getAll();
	public long getNumberOfTicketsByVeicleId(long veicleId);
	public List<Veicle> getVeiclesInService();

}

package DAO;

import java.util.List;

import models.Reseller;
import models.Ticket;

public interface ITicketDAO {
	
	public void save(Ticket r);
	void delete(Long id);
	public Ticket getById(Long id);
	public void update(Ticket e);
	public List<Ticket> getAll();
}

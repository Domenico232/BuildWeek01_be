package interfaces;

import java.time.LocalDate;
import java.util.List;

import models.Pass;

public interface IPassDAO {
	
	public void save(Pass r);
	public Pass getById(long id);
	public List<Pass> getAll();
	public void update(Pass e);
	void delete(long id);
	public List<Pass> listaTotPass(long id, LocalDate inizio, LocalDate fine); 
	public List<Pass> getTicketsNotEndorsed();
	public List<Pass> getEndorsedTicketsInTimeRange(LocalDate startTime, LocalDate endTime);

}

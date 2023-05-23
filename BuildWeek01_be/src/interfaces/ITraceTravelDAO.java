package interfaces;

import java.util.List;
import models.TraceTravel;

public interface ITraceTravelDAO {

	public void save(TraceTravel tt);
	void delete(Long id);
	public TraceTravel getById(Long id);
	public void update(TraceTravel e);
	public List<TraceTravel> getAll();
	
	
}

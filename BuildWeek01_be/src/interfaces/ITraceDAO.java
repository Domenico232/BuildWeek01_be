package interfaces;

import java.util.List;
import java.util.Set;

import models.Trace;

public interface ITraceDAO {
	public void save(Trace trace);
	 public void saveAll(Set<Trace> traces);
	 public Trace getById(long id);
	 public void update(Trace trace);
	 public List<Trace> getAll();
}

package interfaces;

import java.util.List;

import models.TraceTraveled;

public interface ITraceTraveledDAO {
	public void save(TraceTraveled traceTraveled);
	public TraceTraveled getById(long id);
	public void update(TraceTraveled traceTraveled);
	 public List<TraceTraveled> getAll();
}

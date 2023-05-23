package models;

import java.sql.Time;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "tuttiTraceTravel", query = "SELECT tt FROM TraceTravel tt")
public class TraceTravel {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToMany
	private List<Veicle> veicle;
	
	@ManyToMany
	private List<Trace> trace;
	
	private Time effectiveTime;

	public TraceTravel(List<Veicle> veicle, List<Trace> trace, Time effectiveTime) {
		super();
		this.veicle = veicle;
		this.trace = trace;
		this.effectiveTime = effectiveTime;
	}

	public TraceTravel() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Veicle> getVeicle() {
		return veicle;
	}

	public void setVeicle(List<Veicle> veicle) {
		this.veicle = veicle;
	}

	public List<Trace> getTrace() {
		return trace;
	}

	public void setTrace(List<Trace> trace) {
		this.trace = trace;
	}

	public Time getEffectiveTime() {
		return effectiveTime;
	}

	public void setEffectiveTime(Time effectiveTime) {
		this.effectiveTime = effectiveTime;
	}

	@Override
	public String toString() {
		return "TraceTravel [id=" + id + ", veicle=" + veicle + ", trace=" + trace + ", effectiveTime=" + effectiveTime
				+ "]";
	}
	
}

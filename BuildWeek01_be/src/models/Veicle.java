package models;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import enumerates.TypeStatus;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
@Table(name = "veicles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Veicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id = -1;

	@Enumerated(EnumType.STRING)
	protected TypeStatus typeStatus;

	@ManyToMany(fetch = FetchType.EAGER)
	protected List<Trace> traces;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TypeStatus getTypeStatus() {
		return this.typeStatus;
	}

	public void setTypeStatus(TypeStatus typeStatus) {
		this.typeStatus = typeStatus;
	}

	public List<Trace> getListTraces() {
		return this.traces;
	}

	public void setListTraces(List<Trace> traces) {
		this.traces = traces;
	}

	public void addTrace(Trace trace) {
		if (this.traces == null) {
			this.traces = new ArrayList<Trace>();
		} else {
			this.traces.add(trace);
		}
	}

	@Override
	public String toString() {
		return "Veicle [id=" + id + ", typeStatus=" + typeStatus + ", traces=" + traces + "]";
	}

}

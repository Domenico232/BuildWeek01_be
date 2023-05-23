package models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import enumerates.ServiceVeicle;

import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@Table(name = "veicles")
@NamedQuery(name = "tuttiVeicle", query = "SELECT v FROM Veicle v")
public class Veicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private ServiceVeicle serviceVeicle;
	
	@OneToMany
	private Set<Trace> listTrace;
	
	@OneToMany
	private Set<Pass> listTicket;

	public Veicle() {
		super();
	}

	public Veicle(ServiceVeicle serviceVeicle, Set<Trace> listTrace, Set<Pass> listTicket) {
		super();
		this.serviceVeicle = serviceVeicle;
		this.listTrace = listTrace;
		this.listTicket = listTicket;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ServiceVeicle getServiceVeicle() {
		return serviceVeicle;
	}

	public void setServiceVeicle(ServiceVeicle serviceVeicle) {
		this.serviceVeicle = serviceVeicle;
	}

	public Set<Trace> getListTrace() {
		return listTrace;
	}

	public void setListTrace(Set<Trace> listTrace) {
		this.listTrace = listTrace;
	}

	public Set<Pass> getListTicket() {
		return listTicket;
	}

	public void setListTicket(Set<Pass> listTicket) {
		this.listTicket = listTicket;
	}

	@Override
	public String toString() {
		return "Veicle [id=" + id + ", serviceVeicle=" + serviceVeicle + ", listTrace="
				+ listTrace + ", listTicket=" + listTicket + "]";
	}
	
	
}

package models;

import java.util.Set;

import javax.persistence.Column;

import enumerates.ServiceVeicle;

public class Autobus extends Veicle {
	
	@Column(nullable = false)
	private Integer capienza;

	public Autobus() {
		super();
	}

	public Autobus( ServiceVeicle serviceVeicle, Set<Trace> listTrace, Set<Pass> listTicket, Integer capienza) {
		super(serviceVeicle, listTrace, listTicket);
		this.capienza = 50;
	}

	public Integer getCapienza() {
		return capienza;
	}

	public void setCapienza(Integer capienza) {
		this.capienza = capienza;
	}

	@Override
	public String toString() {
		return super.toString() + "Autobus [capienza=" + capienza + "]";
	}
	
}

package models;

import java.util.Set;

import javax.persistence.Column;

import enumerates.ServiceVeicle;

public class Tram extends Veicle {

	@Column(nullable = false)
	private Integer capienza;

	public Tram() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tram(ServiceVeicle serviceVeicle, Set<Trace> listTrace, Set<Pass> listPass, Integer capienza) {
		super(serviceVeicle, listTrace, listPass);
		this.capienza = 70; 
	}

	public Integer getCapienza() {
		return capienza;
	}

	public void setCapienza(Integer capienza) {
		this.capienza = capienza;
	}

	@Override
	public String toString() {
		return super.toString() + "Tram [capienza=" + capienza + "]";
	}
	
	
	
}

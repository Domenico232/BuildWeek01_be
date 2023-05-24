package models;

import java.util.Set;

import javax.persistence.Column;

import enumerates.TypeStatus;

public class Bus extends Veicle {

	@Column(nullable = false)
	private static int seats = 30;

	public Bus() {

	}

	public Bus(TypeStatus typeStatus, Set<Trace> listTrace) {
		this.typeStatus = typeStatus;
		this.traces = listTrace;
	}

	public static int getSeats() {
		return Bus.seats;
	}

	public static void setSeats(int seats) {
		Bus.seats = seats;
	}

	@Override
	public String toString() {
		return "Bus [id=" + id + ", typeStatus=" + typeStatus + ", traces=" + traces + "]";
	}

}

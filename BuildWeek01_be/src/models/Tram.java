package models;

import java.util.Set;

import javax.persistence.Column;

import enumerates.TypeStatus;

public class Tram extends Veicle {

	@Column(nullable = false)
	private static int seats = 100;

	public Tram() {

	}

	public Tram(TypeStatus typeStatus, Set<Trace> listTrace) {
		this.typeStatus = typeStatus;
		this.traces = listTrace;
	}

	public static int getSeats() {
		return Tram.seats;
	}

	public static void setSeats(int seats) {
		Tram.seats = seats;
	}

	@Override
	public String toString() {
		return "Tram [id=" + id + ", typeStatus=" + typeStatus + ", traces=" + traces + "]";
	}

}

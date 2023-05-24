package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import enumerates.TypeStatus;

@Entity
public class Tram extends Veicle {

	@Column(nullable = false)
	private static int seats = 100;

	public Tram() {

	}

	public Tram(TypeStatus typeStatus, List<Trace> traces) {
		this.typeStatus = typeStatus;
		this.traces = traces;
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

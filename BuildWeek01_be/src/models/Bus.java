package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import enumerates.TypeStatus;

@Entity
public class Bus extends Veicle {

	@Column(nullable = false)
	private static int seats = 30;

	public Bus() {

	}

	public Bus(TypeStatus typeStatus, List<Trace> traces) {
		this.typeStatus = typeStatus;
		this.traces = traces;
	}

	public static int getSeats() {
		return Bus.seats;
	}

	public static void setSeats(int seats) {
		Bus.seats = seats;
	}

	@Override
	public String toString() {
		return "Bus [id=" + id + ", typeStatus=" + typeStatus + ", traces=" + traces + ", seats=" + Bus.seats + "]";
	}

}

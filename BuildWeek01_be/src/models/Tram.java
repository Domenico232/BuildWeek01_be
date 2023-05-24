package models;

import java.util.List;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;

import dao.TraceDAO;
import enumerates.TypeStatus;

@Entity
public class Tram extends Veicle {

	@Column(nullable = false)
	private static int seats = 100;

	public Tram() {

	}
	public Tram(TypeStatus typeStatus) {
		this.typeStatus = typeStatus;
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

	public static Tram randomTram() {
		Random rand = new Random();
		TypeStatus randType = rand.nextBoolean() ? TypeStatus.SERVIZIO : TypeStatus.MANUTENZIONE;
		Tram tram = new Tram(randType);
		TraceDAO traceDAO = new TraceDAO();
		List<Trace> traces = traceDAO.getAll();

		int numberOfTraces = rand.nextInt(2) + 1;

		for (int i = 0; i < numberOfTraces; i++) {
			int index = rand.nextInt(traces.size());

			tram.addTrace(traces.get(index));
		}
		return tram;
	}
}

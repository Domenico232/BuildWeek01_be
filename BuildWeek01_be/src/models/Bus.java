package models;

import java.util.List;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;

import dao.TraceDAO;
import enumerates.TypeStatus;

import java.lang.UnsupportedOperationException;

@Entity
public class Bus extends Veicle {

	@Column(nullable = false)
	private static int seats = 30;

	public Bus() {

	}

	public Bus(TypeStatus typeStatus) {
		this.typeStatus = typeStatus;
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

	public static Bus randomBus() {
		Random rand = new Random();
		TypeStatus randType = rand.nextBoolean() ? TypeStatus.SERVIZIO : TypeStatus.MANUTENZIONE;
		Bus bus = new Bus(randType);
		TraceDAO traceDAO = new TraceDAO();
		List<Trace> traces = traceDAO.getAll();

		int numberOfTraces = rand.nextInt(20) + 0;

		for (int i = 0; i < numberOfTraces; i++) {
			int index = rand.nextInt(traces.size());

			bus.addTrace(traces.get(index));
		}
		return bus;
	}

}

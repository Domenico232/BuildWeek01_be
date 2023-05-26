package models;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import javax.persistence.Entity;

import dao.ResellerDAO;
import dao.TraceDAO;

@Entity
public class Ticket extends Pass {

	private Boolean endorsed = false;

	public Ticket() {

	}

	public Ticket(String name, String description, double price,
			Reseller reseller, LocalDate creationDate, Boolean endorsed) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.reseller = reseller;
		this.creationDate = creationDate;
		this.endorsed = endorsed;
	}

	public Ticket(long id, String name, String description, double price,
			Reseller reseller, LocalDate creationDate, Boolean endorsed) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.reseller = reseller;
		this.creationDate = creationDate;
		this.endorsed = endorsed;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return this.price;
	}

	public Trace getTrace() {
		return this.trace;
	}

	public void setTrace(Trace trace) {
		this.trace = trace;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Reseller getReseller() {
		return this.reseller;
	}

	public void setReseller(Reseller reseller) {
		this.reseller = reseller;
	}

	public LocalDate getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public Veicle getVeicle() {
		return this.veicle;
	}

	public void setVeicle(Veicle veicle) {
		this.veicle = veicle;
	}

	public Boolean getEndorsed() {
		return this.endorsed;
	}

	public void setEndorsed(Boolean endorsed) {
		this.endorsed = endorsed;
	}

	@Override
	public String toString() {
		return super.toString() + "Ticket [endorsed=" + endorsed + "]";
	}

	public static Ticket randomTicket() {
		Random random = new Random();
		ResellerDAO resellerDAO = new ResellerDAO();
		TraceDAO traceDAO = new TraceDAO();
		List<Trace> traces = traceDAO.getAll();
		if (traces.isEmpty()) {
			System.out.println("No traces for tickets");
			return null;
		}
		List<Reseller> resellers = resellerDAO.getAll();
		if (resellers.isEmpty()) {
			System.out.println("No resellers");
			return null;
		}
		Reseller randomReseller = resellers.get(random.nextInt(resellers.size()));
		String[] names = { "Ticket A", "Ticket B", "Ticket C" };
		String[] descriptions = { "Description A", "Description B", "Description C" };
		double[] prices = { 10.0, 20.0, 30.0 };
		String name = names[random.nextInt(names.length)];
		String description = descriptions[random.nextInt(descriptions.length)];
		double price = prices[random.nextInt(prices.length)];
		Ticket ticket = new Ticket();
		ticket.setTrace(traces.get(random.nextInt(traces.size())));
		ticket.setName(name);
		ticket.setDescription(description);
		ticket.setPrice(price);
		ticket.setEndorsed(false);
		ticket.setReseller(randomReseller);
		ticket.setCreationDate(LocalDate.now().minusYears(2).plusDays(random.nextInt(730))); // from 2 years ago
		return ticket;
	}

}

package models;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import javax.persistence.Entity;

import dao.ResellerDAO;
import dao.TraceDAO;

@Entity
public class Ticket extends Pass{
	
	private Boolean endorsed = false;
	
	
    public Ticket() {

	}

    public Ticket(String name, String description, double price) {
		super(name, description, price);
    }

	public Ticket(String name, String description, double price, Boolean endorsed) {
		super(name, description, price);
		this.endorsed = endorsed;
	}

	public Ticket(long id, String name, String description, double price, Reseller reseller, Boolean endorsed) {
		super(id, name, description, price, reseller);
		this.endorsed = endorsed;
	}

	public Ticket(String name, String description, double price, Reseller reseller, Boolean endorsed,LocalDate emissionDate) {
		super(name, description, price, reseller,emissionDate);
		this.endorsed = endorsed;
	}

	public Boolean getEndorsed() {
		return endorsed;
	}

	public void setEndorsed(Boolean endorsed) {
		this.endorsed = endorsed;
	}
	
	@Override
	public void setEmissionDate(LocalDate emissionDate) {
		super.setEmissionDate(emissionDate);
	}

    @Override
    public String toString() {
		return super.toString() + "Ticket [endorsed=" + endorsed + "]";
    }

	public static Ticket randomTicket() {
		Random random = new Random();
		ResellerDAO resellerDAO = new ResellerDAO();
		TraceDAO traceDAO =new TraceDAO();
		List<Trace> traces = traceDAO.getAll();
		if(traces.isEmpty()) {
			System.out.println("No traces for tickets");
			return null;
		}
		List<Reseller> resellers = resellerDAO.getAll();
		if(resellers.isEmpty()) {
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
	
		return ticket;
	}

}

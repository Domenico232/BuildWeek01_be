package models;

import java.util.Random;

import javax.persistence.Entity;

@Entity
public class Ticket extends Pass{
	private Boolean endorsed;
	
	public Ticket() {
		super();
		
	}

	public Ticket(int id, String name, String description, double price, Boolean endorsed) {
		super(id, name, description, price);
		this.endorsed = endorsed;
		}

	public Ticket(String name, String description, double price, Boolean endorsed) {
		super(name, description, price);
		this.endorsed = endorsed;
		
	}

	public Boolean getEndorsed() {
		return endorsed;
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
	        String[] names = { "Ticket A", "Ticket B", "Ticket C" };
	        String[] descriptions = { "Description A", "Description B", "Description C" };
	        double[] prices = { 10.0, 20.0, 30.0 };
	        String name = names[random.nextInt(names.length)];
	        String description = descriptions[random.nextInt(descriptions.length)];
	        double price = prices[random.nextInt(prices.length)];
	        Ticket Ticket = new Ticket();
	        Ticket.setName(name);
	        Ticket.setDescription(description);
	        Ticket.setPrice(price);
	        Ticket.setEndorsed(true);
	        return Ticket;
	    }
	
}

package models;

import java.time.LocalDate;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
public class Ticket extends Pass{
	private Boolean endorsed;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private double price;
    
    @OneToOne
    private Trace trace;

    public Ticket() {

    }

    public Ticket(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
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
        return "Ticket [id=" + id + ", name=" + name + ", description=" +
                description + ", price=" + price + "]";
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

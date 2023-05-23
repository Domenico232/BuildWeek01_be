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
//@NamedQuery(name = "biglettiEmessiPerData", query = "SELECT t FROM Ticket t WHERE reseller.id = :prmt AND BETWEEN :data1 AND :data2 ")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private double price;
    private LocalDate dataEmissione = LocalDate.now();
    
    @ManyToOne 
    private Reseller reseller;
    
    @OneToOne
    private Trace trace;

    public Ticket() {
		super();
	}
    
	public Ticket(String name, String description, double price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Ticket(String name, String description, double price, Reseller reseller, Trace trace) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.reseller = reseller;
		this.trace = trace;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Reseller getReseller() {
		return reseller;
	}

	public void setReseller(Reseller reseller) {
		this.reseller = reseller;
	}

	public Trace getTrace() {
		return trace;
	}

	public void setTrace(Trace trace) {
		this.trace = trace;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", reseller=" + reseller + ", trace=" + trace + "]";
	}

	public static Ticket randomTicket() {
        Random random = new Random();
        String[] names = { "Ticket A", "Ticket B", "Ticket C" };
        String[] descriptions = { "Description A", "Description B", "Description C" };
        double[] prices = { 10.0, 20.0, 30.0 };

        String name = names[random.nextInt(names.length)];
        String description = descriptions[random.nextInt(descriptions.length)];
        double price = prices[random.nextInt(prices.length)];

        return new Ticket(name, description, price);
    }

}

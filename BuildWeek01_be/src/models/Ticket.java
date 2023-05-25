package models;

import java.util.List;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import dao.ResellerDAO;

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

	public Ticket(String name, String description, double price, Reseller reseller, Boolean endorsed) {
		super(name, description, price, reseller);
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
		ResellerDAO resellerDAO = new ResellerDAO();
		List<Reseller> resellers = resellerDAO.getAll();
		Reseller randomReseller = resellers.get(random.nextInt(resellers.size()));
		String[] names = { "Ticket A", "Ticket B", "Ticket C" };
		String[] descriptions = { "Description A", "Description B", "Description C" };
		double[] prices = { 10.0, 20.0, 30.0 };
		String name = names[random.nextInt(names.length)];
		String description = descriptions[random.nextInt(descriptions.length)];
		double price = prices[random.nextInt(prices.length)];
		Ticket ticket = new Ticket();
		ticket.setName(name);
		ticket.setDescription(description);
		ticket.setPrice(price);
		ticket.setEndorsed(false);
		ticket.setReseller(randomReseller);
		return ticket;
	}

}

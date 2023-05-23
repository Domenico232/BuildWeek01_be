package models;

import java.util.Random;

import javax.persistence.Entity;

@Entity
public class Ticket extends Pass {
	private Boolean endorsed;

	public Ticket() {

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
		return "Ticket [id=" + super.getId() + ", name=" + super.getName() + ", description=" +
				super.getDescription() + ", price=" + super.getPrice() + "]";
	}

	public static Ticket randomTicket() {
		Random random = new Random();
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
		return ticket;
	}

}

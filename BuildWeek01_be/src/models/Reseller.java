package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="resellers")
@NamedQuery(name = "tuttiReseller", query = "SELECT r FROM Reseller r")
public class Reseller {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	@OneToMany
	private List <Ticket> ticketSell;

	public Reseller() {
		super();
	}

	public Reseller(String name, List<Ticket> ticketSell) {
		super();
		this.name = name;
		this.ticketSell = ticketSell;
	}

	public Reseller(long id, String name, List<Ticket> ticketSell) {
		super();
		this.id = id;
		this.name = name;
		this.ticketSell = ticketSell;
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

	public List<Ticket> getTicketSell() {
		return ticketSell;
	}

	public void setTicketSell(List<Ticket> ticketSell) {
		this.ticketSell = ticketSell;
	}

	@Override
	public String toString() {
		return "Reseller [id=" + id + ", name=" + name + ", ticketSell=" + ticketSell + "]";
	}
	
}

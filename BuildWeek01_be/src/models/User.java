package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@Table(name= "users")
@NamedQuery(name = "tuttiUser", query = "SELECT u FROM User u")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	private String name;
	
	@OneToOne
	private Card card;
	
	public User() {
		super();
	}

	public User(Card card) {
		super();
		this.card = card;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", name=" + name + ", card=" + card + "]";
	}

	
}

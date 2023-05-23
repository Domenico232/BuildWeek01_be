package models;

import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;

@Entity
@Table(name = "users")
@NamedQuery(name = "tuttiUser", query = "SELECT u FROM User u")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name = "card_id")
	private Card card;

	public User() {

	}

	public User(String name) {
		this.name = name;
	}

	public User(String name, Card card) {

		this.name = name;
		this.card = card;
	}

	public User(Long id, String name, Card card) {
		this.id = id;
		this.name = name;
		this.card = card;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return "User [id=" + id + ", name=" + name + "]";
	}

	public static User randomUser() {
		String[] names = { "Eren", "Mikasa", "Armin", "Levi", "Erwin", "Hange", "Sasha", "Jean", "Connie", "Historia" };
		Random rand = new Random();
		String randomName = names[rand.nextInt(names.length)];
		return new User(randomName);
	}

}

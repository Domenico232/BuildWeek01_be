package models;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@Table(name = "users")
@NamedQuery(name = "tuttiUser", query = "SELECT u FROM User u")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	public User() {

	}

	public User(String name) {
		this.name = name;
	}

	public User(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

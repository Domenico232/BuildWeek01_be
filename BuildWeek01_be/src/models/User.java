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

	private String surname;

	public User() {

	}

	public User(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public User(Long id, String name, String surname) {
		this.id = id;
		this.name = name;
		this.surname = surname;
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

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}

	public static User randomUser() {
		String[] names = {
				"Eren", "Mikasa", "Armin", "Levi", "Erwin",
				"Hange", "Sasha", "Jean", "Connie", "Historia" };
		String[] surnames = {
				"Yeager", "Ackerman", "Arlelt", "Ackerman", "Smith",
				"Zoë", "Braus", "Kirschtein", "Springer", "Reiss" };
		Random rand = new Random();
		int index = rand.nextInt(names.length);
		String randomName = names[index];
		String randomSurname = surnames[index];
		return new User(randomName, randomSurname);
	}

}

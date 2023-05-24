package models;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.InheritanceType;

@Entity
@Table(name = "resellers")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQuery(name = "tuttiReseller", query = "SELECT r FROM Reseller r")

public class Reseller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id = -1;

	private String name;

	public Reseller() {

	}

	public Reseller(String name) {
		this.name = name;
	}

	public Reseller(long id, String name) {
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "Reseller [id=" + id + ", name=" + name + "]";
	}

	public static Reseller randomReseller() {
		String[] names = {
				"Acme Inc.", "Globex Corporation", "Wayne Enterprises",
				"Spacely Sprockets", "Monarch Solutions" };
		Random rand = new Random();
		String randomName = names[rand.nextInt(names.length)];
		return new Reseller(randomName);
	}

}

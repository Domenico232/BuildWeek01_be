package models;

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
	private long id;

	private String name;

	public Reseller() {
		super();
	}

	public Reseller(String name) {
		super();
		this.name = name;
	}

	public Reseller(long id, String name) {
		super();
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

}

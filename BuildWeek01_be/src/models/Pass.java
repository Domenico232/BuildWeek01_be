package models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = -1;
    private String name;
    private String description;
    private double price;
    private LocalDate emissionDate = LocalDate.now();

    @OneToOne
    private Trace trace;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Reseller reseller;

    public Pass() {

    }

    public Pass(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Pass(long id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Pass(int id, String name, String description, double price,
            Reseller reseller) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.reseller = reseller;
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

    public void setName(String names) {
        this.name = names;
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
        return this.reseller;
    }

    public void setReseller(Reseller reseller) {
        this.reseller = reseller;
    }
    
    public LocalDate getEmissionDate() {
		return emissionDate;
	}

	public void setEmissionDate(LocalDate emissionDate) {
		this.emissionDate = emissionDate;
	}

	@Override
    public String toString() {
        return "Ticket [id=" + id + ", name=" + name + ", description=" +
                description + ", price=" + price + "]";
    }
}

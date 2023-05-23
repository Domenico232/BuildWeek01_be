package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pass{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = -1;
    private String name;
    private String description;
    private double price;
    
    @OneToOne
    private Trace trace;

    public Pass() {

    }

    public Pass(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Pass(int id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
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

    @Override
    public String toString() {
        return "Ticket [id=" + id + ", name=" + name + ", description=" +
                description + ", price=" + price + "]";
    }

    /*public static Pass randomTicket() {
        Random random = new Random();
        String[] names = { "Ticket A", "Ticket B", "Ticket C" };
        String[] descriptions = { "Description A", "Description B", "Description C" };
        double[] prices = { 10.0, 20.0, 30.0 };

        String name = names[random.nextInt(names.length)];
        String description = descriptions[random.nextInt(descriptions.length)];
        double price = prices[random.nextInt(prices.length)];

        return new Pass(name, description, price);*/
    }



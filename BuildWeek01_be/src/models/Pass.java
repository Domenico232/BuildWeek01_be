package models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Pass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id = -1;
    protected String name;
    protected String description;
    protected double price;

    @Column(name = "creation_date")
    protected LocalDate creationDate;

    @OneToOne
    @JoinColumn(nullable = false)
    protected Trace trace;

    @ManyToOne(cascade = CascadeType.REMOVE)
    protected Reseller reseller;

    @OneToOne(cascade = CascadeType.REMOVE)
    protected Veicle veicle;

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

    public Trace getTrace() {
        return trace;
    }

    public void setTrace(Trace trace) {
        this.trace = trace;
    }

    public Reseller getReseller() {
        return this.reseller;
    }

    public void setReseller(Reseller reseller) {
        this.reseller = reseller;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Veicle getVeicle() {
        return veicle;
    }

    public void setVeicle(Veicle veicle) {
        this.veicle = veicle;
    }

    @Override
    public String toString() {
        return "Ticket [id=" + id + ", name=" + name + ", description=" +
                description + ", price=" + price + ", trace=" + trace +
                ", reseller=" + reseller + ", veicle=" + veicle + "]";
    }
}

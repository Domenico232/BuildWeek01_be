package models;

import java.util.Random;

import javax.persistence.Entity;

import enumerates.TypeSubscription;

import models.Ticket;

@Entity
public class Subscription extends Ticket {
    private TypeSubscription typeSubscription;

    public Subscription() {
        super();
    }

    public Subscription(String name, String description, double price,
            TypeSubscription typeSubscription) {
        super(name, description, price);
        this.typeSubscription = typeSubscription;
    }

    public Subscription(int id, String name, String description, double price,
            TypeSubscription typeSubscription) {
        super(id, name, description, price);
        this.typeSubscription = typeSubscription;
    }

    public TypeSubscription getTypeSubscription() {
        return typeSubscription;
    }

    public void setTypeSubscription(TypeSubscription typeSubscription) {
        this.typeSubscription = typeSubscription;
    }

    @Override
    public String toString() {
        return super.toString() + ", typeSubscription=" + typeSubscription;
    }

    public static Subscription randomSubscription() {
        Ticket ticket = Ticket.randomTicket();
        Subscription subscription = new Subscription();
        subscription.setName(ticket.getName());
        subscription.setDescription(ticket.getDescription());
        subscription.setPrice(ticket.getPrice());
        subscription
                .setTypeSubscription(TypeSubscription.values(
                )[new Random().nextInt(TypeSubscription.values().length)]);
        return subscription;
    }

}

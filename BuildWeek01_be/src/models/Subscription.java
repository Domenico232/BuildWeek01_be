package models;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import enumerates.TypeSubscription;

import models.Ticket;

@Entity
public class Subscription extends Ticket {
    private TypeSubscription typeSubscription;
    
    @ManyToOne
    private Card card;

    public Subscription() {
        super();
    }

    public Subscription(String name, String description, double price,
            TypeSubscription typeSubscription, Card card) {
        super(name, description, price);
        this.typeSubscription = typeSubscription;
        this.card = card;
    }
    
    public TypeSubscription getTypeSubscription() {
        return typeSubscription;
    }

    public void setTypeSubscription(TypeSubscription typeSubscription) {
        this.typeSubscription = typeSubscription;
    }

    public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return super.toString() + "Subscription [typeSubscription=" + typeSubscription + ", card=" + card + "]";
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

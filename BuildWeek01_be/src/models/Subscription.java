package models;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import enumerates.TypeSubscription;

@Entity
public class Subscription extends Pass {
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

    public long getId() {
        return super.getId();
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
        Random random = new Random();
        String[] names = { "Subscription A", "Subscription B", "Subscription C" };
        String[] descriptions = { "Fiera A", "Metro B", "Stazione C" };
        double[] prices = { 10.0, 20.0, 30.0 };
        String name = names[random.nextInt(names.length)];
        String description = descriptions[random.nextInt(descriptions.length)];
        double price = prices[random.nextInt(prices.length)];
        Subscription subscription = new Subscription();
        subscription.setName(name);
        subscription.setDescription(description);
        subscription.setPrice(price);
        subscription
                .setTypeSubscription(TypeSubscription.values()[new Random().nextInt(TypeSubscription.values().length)]);
        return subscription;
    }

}

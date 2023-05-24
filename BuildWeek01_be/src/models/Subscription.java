package models;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import enumerates.TypeSubscription;

@Entity
public class Subscription extends Pass {
    @Enumerated(EnumType.STRING)
    private TypeSubscription typeSubscription;

    public Subscription() {
        super();
    }

    public Subscription(String name, String description, double price, Reseller reseller,
            TypeSubscription typeSubscription) {
        super(name, description, price, reseller);
        this.typeSubscription = typeSubscription;
    }
    
    public Subscription(long id, String name, String description, double price, Reseller reseller, TypeSubscription typeSubscription) {
		super(id, name, description, price, reseller);
        this.typeSubscription = typeSubscription;
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

    @Override
    public String toString() {
        return super.toString() + "Subscription [typeSubscription=" + typeSubscription + "]";
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

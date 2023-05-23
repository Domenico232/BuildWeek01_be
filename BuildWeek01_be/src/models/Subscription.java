package models;

import java.util.Random;

import javax.persistence.Entity;

import enumerates.TypeSubscription;

@Entity
public class Subscription extends Pass {
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
        return super.toString() + ", typeSubscription=" + typeSubscription;
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

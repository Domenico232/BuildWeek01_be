package models;

import java.util.Random;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

import dao.CardDAO;
import dao.ResellerDAO;
import dao.TraceDAO;
import enumerates.TypeSubscription;

@Entity
public class Subscription extends Pass {
    @Enumerated(EnumType.STRING)
    private TypeSubscription typeSubscription;
    private LocalDate expirationDate;

    @OneToOne
    private Card card;

    public Subscription() {
        super();
    }

    public Subscription(String name, String description, double price,
            Reseller reseller, LocalDate creationDate,
            TypeSubscription typeSubscription) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.reseller = reseller;
        this.creationDate = creationDate;
        this.setExpirationDate();
        this.typeSubscription = typeSubscription;
    }

    public Subscription(long id, String name, String description, double price,
            Reseller reseller, LocalDate creationDate,
            TypeSubscription typeSubscription) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.reseller = reseller;
        this.creationDate = creationDate;
        this.setExpirationDate();
        this.typeSubscription = typeSubscription;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return this.price;
    }

    public Trace getTrace() {
        return this.trace;
    }

    public void setTrace(Trace trace) {
        this.trace = trace;
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

    public LocalDate getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        this.setExpirationDate();
    }

    public Veicle getVeicle() {
        return this.veicle;
    }

    public void setVeicle(Veicle veicle) {
        this.veicle = veicle;
    }

    public TypeSubscription getTypeSubscription() {
        return typeSubscription;
    }

    public void setTypeSubscription(TypeSubscription typeSubscription) {
        this.typeSubscription = typeSubscription;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    private void setExpirationDate() {
        if (typeSubscription == TypeSubscription.WEEKLY) {
            expirationDate = this.creationDate.plusWeeks(1);
        } else if (typeSubscription == TypeSubscription.MONTHLY) {
            expirationDate = this.creationDate.plusMonths(1);
        } else {
            System.out.println("No expiration date");
        }
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", reseller=" + reseller +
                ", veicle=" + veicle +
                ", trace=" + trace +
                ", creationDate=" + creationDate +
                ", expirationDate=" + expirationDate +
                ", typeSubscription=" + typeSubscription +
                '}';
    }

    public static Subscription randomSubscription() {
        ResellerDAO resellerDAO = new ResellerDAO();
        List<Reseller> resellers = resellerDAO.getAll();

        TraceDAO traceDAO = new TraceDAO();
        List<Trace> traces = traceDAO.getAll();
        if (traces.isEmpty()) {
            System.out.println("No traces for subscriptions");
            return null;
        }

        if (resellers.isEmpty()) {
            System.out.println("No resellers for subscriptions");
            return null;
        }
        CardDAO cardDAO = new CardDAO();
        List<Card> cards = cardDAO.getAll();
        if (cards.isEmpty()) {
            System.out.println("No cards");
            return null;
        }
        Random random = new Random();
        String[] names = { "Subscription A", "Subscription B", "Subscription C" };
        String[] descriptions = { "Fiera A", "Metro B", "Stazione C" };
        double[] prices = { 10.0, 20.0, 30.0 };
        String name = names[random.nextInt(names.length)];
        String description = descriptions[random.nextInt(descriptions.length)];
        double price = prices[random.nextInt(prices.length)];
        Card card = cards.get(random.nextInt(cards.size()));
        Reseller reseller = resellers.get(random.nextInt(resellers.size()));
        Subscription subscription = new Subscription();

        subscription
                .setTypeSubscription(TypeSubscription.values()[new Random().nextInt(TypeSubscription.values().length)]);
        subscription.setCreationDate(LocalDate.now().minusYears(2).plusDays(random.nextInt(730)));
        subscription.setTrace(traces.get(random.nextInt(traces.size())));
        subscription.setName(name);
        subscription.setDescription(description);
        subscription.setPrice(price);
        subscription.setReseller(reseller);
        subscription.setCard(card);
        return subscription;
    }
}

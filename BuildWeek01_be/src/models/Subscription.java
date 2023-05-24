package models;

import java.util.Random;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

import dao.ResellerDAO;
import enumerates.TypeSubscription;

@Entity
public class Subscription extends Pass {
    @Enumerated(EnumType.STRING)
    private TypeSubscription typeSubscription;
   private LocalDate dataScadenza;
   
   @OneToOne
   private Card card;
   
    public Subscription() {
        super();
    }

    public Subscription(String name, String description, double price, Reseller reseller,
            TypeSubscription typeSubscription) {
        super(name, description, price, reseller);
        if( typeSubscription == TypeSubscription.MONTHLY) {
        	this.dataScadenza =super.getEmissionDate().plusMonths(1); 
        	this.typeSubscription = typeSubscription;
           }else if (typeSubscription == TypeSubscription.WEEKLY) {
        	  this.dataScadenza =super.getEmissionDate().plusWeeks(1); 	 
        	  this.typeSubscription = typeSubscription;
           }
        
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

//    @Override
//    public String toString() {
//        return super.toString() + "Subscription [typeSubscription=" + typeSubscription + "]";
//    }

    @Override
    public String toString() {
    	return "Subscription [typeSubscription=" + typeSubscription + ", dataScadenza=" + dataScadenza + "]";
    }
    
    public static Subscription randomSubscription() {
        ResellerDAO resellerDAO = new ResellerDAO();
		List<Reseller> resellers = resellerDAO.getAll();
        if(resellers.isEmpty()) {
            resellerDAO.save(Reseller.randomReseller());
            resellers = resellerDAO.getAll();
        }
		Random random = new Random();
        String[] names = { "Subscription A", "Subscription B", "Subscription C" };
        String[] descriptions = { "Fiera A", "Metro B", "Stazione C" };
        double[] prices = { 10.0, 20.0, 30.0 };
        String name = names[random.nextInt(names.length)];
        String description = descriptions[random.nextInt(descriptions.length)];
        double price = prices[random.nextInt(prices.length)];
        Reseller reseller = resellers.get(random.nextInt(resellers.size()));
        Subscription subscription = new Subscription();
        subscription.setName(name);
        subscription.setDescription(description);
        subscription.setPrice(price);
        subscription.setTypeSubscription(TypeSubscription.values()[new Random().nextInt(TypeSubscription.values().length)]);
      
        subscription.setReseller(reseller);
        return subscription;
    }


}

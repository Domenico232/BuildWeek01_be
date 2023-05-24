package models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.engine.internal.Cascade;

@Entity
@Table(name = "cards")
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id = -1;

	private LocalDate creationDate;
	private LocalDate expirationDate = creationDate.plusYears(1);

	@OneToOne(mappedBy = "card")
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToOne
	private Subscription subscription;	
	
	//@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//private Set<Subscription> subscription;

	public Card() {

	}

	public Card(LocalDate creationDate, User user, Subscription subscription) {
		super();
		this.creationDate = creationDate;
		this.user = user;
		this.subscription = subscription;
	}

	public Card(long id, LocalDate creationDate, User user, Subscription subscription) {
		this.id = id;
		this.creationDate = creationDate;
		this.user = user;
		this.subscription = subscription;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", creationDate=" + creationDate +
				", expirationDate=" + expirationDate + "]";
	}

	public boolean isExpired() {
		return LocalDate.now().isAfter(expirationDate);
	}

	public void renew() {
		LocalDate today = LocalDate.now();
		setExpirationDate(today.plusYears(1));
	}

//	public void addSubscription(Subscription subscription) {
//		if (this.subscription == null) {
//			this.subscription = new HashSet <Subscription>();
//		}
//		this.subscription.add(subscription);
//	}

//	public static Card randomCard() {
//		Random random = new Random();
//		LocalDate creationDate = LocalDate.now().minusYears(5).plusDays(random.nextInt(1826));
//		return new Card(creationDate);
//	}
}

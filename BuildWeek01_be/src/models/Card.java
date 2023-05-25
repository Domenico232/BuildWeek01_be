package models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cards")
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id = -1;

	private LocalDate creationDate;
	private LocalDate expirationDate;
	public static int duration = 1;

	@OneToOne
	private User user;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Subscription> subscriptions;

	public Card() {

	}

	public Card(LocalDate creationDate, User user) {
		super();
		this.creationDate = creationDate;
		this.expirationDate = creationDate.plusYears(Card.duration);
		this.user = user;	
	}

	public Card(LocalDate creationDate) {
		this.creationDate = creationDate;
		this.expirationDate = creationDate.plusYears(Card.duration);
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

	public static int getDuration() {
		return duration;
	}

	public static void setDuration(int duration) {
		Card.duration = duration;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	public Set<Subscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscription(Set<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}


	@Override
	public String toString() {
		return "Card [id=" + id + ", creationDate=" + creationDate + ", expirationDate=" + expirationDate
				+ ", subscriptions=" + subscriptions + ", user=" + user + "]";
	}

	public boolean isExpired() {
		return LocalDate.now().isAfter(expirationDate);
	}

	public void renew() {
		LocalDate today = LocalDate.now();
		setExpirationDate(today.plusYears(1));
	}

	public void addSubscription(Subscription subscription) {
		if (this.subscriptions == null) {
			this.subscriptions = new HashSet<Subscription>();
		}
		this.subscriptions.add(subscription);
	}

	public static Card randomCard() {
		Random random = new Random();
		LocalDate creationDate = LocalDate.now().minusYears(5).plusDays(random.nextInt(1826));
		return new Card(creationDate);
	}
}
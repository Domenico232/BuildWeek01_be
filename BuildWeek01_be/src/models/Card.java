package models;

import java.time.LocalDate;
import java.util.Random;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	public static int duration;

	@OneToOne
    @JoinColumn(name = "user_id")
    private User user;

	@OneToMany
	private Set<Subscription> subscription;

	public Card() {

	}

	public Card(LocalDate creationDate, LocalDate expirationDate, User user, Set<Subscription> subscription) {
		super();
		this.creationDate = creationDate;
		this.expirationDate = creationDate.plusYears(1);
		this.user = user;
		this.subscription = subscription;
	}

	public Card(long id, LocalDate creationDate, LocalDate expirationDate, User user, Set<Subscription> subscription) {
		this.id = id;
		this.creationDate = creationDate;
		this.expirationDate = creationDate.plusYears(1);
		this.user = user;
		this.subscription = subscription;
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

	public Set<Subscription> getSubscription() {
		return subscription;
	}

	public void setSubscription(Set<Subscription> subscription) {
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

	public void addSubscription(Subscription subscription) {
		if (this.subscription == null) {
			this.subscription = Set.of(subscription);
		} else {
			this.subscription.add(subscription);
		}
	}

	public static Card randomCard() {
		Random random = new Random();
		LocalDate creationDate = LocalDate.now().minusYears(5).plusDays(random.nextInt(1826));
		return new Card(creationDate);
	}
}

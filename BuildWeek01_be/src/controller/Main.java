package controller;

import models.Trace;
import models.User;
import models.VendingMachine;
import models.Card;
import models.Reseller;
import models.Subscription;
import models.Ticket;

import java.time.LocalDate;
import java.util.List;

import dao.CardDAO;
import dao.PassDAO;
import dao.ResellerDAO;
import dao.TraceDAO;
import dao.UserDAO;

public class Main {

	public static void main(String[] args) {
		insertReseller(300);
		UserDAO userDAO = new UserDAO();
		CardDAO cardDAO = new CardDAO();
		User user = User.randomUser();
		Card card = new Card(LocalDate.now());
		VendingMachine machine = VendingMachine.randomVendingMachine();
		Subscription subscription = Subscription.randomSubscription();
		card.addSubscription(subscription);
		userDAO.save(user);
		card.setUser(user);
		cardDAO.save(card);
		System.out.println(card);
		System.out.println(machine);
		/*
		 * Reseller reseller1 = new Reseller("franco");
		 * Reseller reseller2 = new Reseller("marco");
		 * Ticket ticket1 = Ticket.randomTicket();
		 * Ticket ticket2 = Ticket.randomTicket();
		 * ResellerDAO resellerDAO = new ResellerDAO();
		 * PassDAO pd1 = new PassDAO();
		 * 
		 * resellerDAO.save(reseller1);
		 * resellerDAO.save(reseller2);
		 * 
		 * //Ticket tt1 = new Ticket("ciao", "stoca", 18.2, reseller2, false);
		 * Subscription s1 = new Subscription("abbonamento 1", "Lombardia", 1300.2,
		 * reseller1);
		 * Subscription s2 = new Subscription("abbonamento 2", "Lazio", 300.2,
		 * reseller2);
		 * pd1.save(s1);
		 * pd1.save(s2);
		 * 
		 * List<Pass> PassTot = s1.listaTotPass(1,LocalDate.of(2023, 5, 23),
		 * LocalDate.of(2023, 5, 25));
		 * PassTot.forEach(e -> System.out.println(e));
		 * 
		 * User u1 = new User("Gianni");
		 * Card c1 = new Card(LocalDate.of(2023, 3, 1), u1, s2);
		 */
	}

	public static void randomSubscriptionTest() {
		Subscription subscription = Subscription.randomSubscription();
		System.out.println(subscription);
	}

	public static Ticket randomTicketTest() {
		Ticket ticket = Ticket.randomTicket();
		System.out.println(ticket);
		return ticket;
	}

	public static void randomTraceTest() {
		Trace trace = Trace.randomTrace();
		System.out.println(trace);
	}

	public static void cardDAOTEst() {
		CardDAO cardDAO = new CardDAO();
		cardDAO.saveAll(List.of(
				Card.randomCard(), Card.randomCard(), Card.randomCard()));
	}

	public static void randomCardTest() {
		Card card = Card.randomCard();
		System.out.println(card);
	}

	public static void insertUsers(int quantity) {
		UserDAO userDAO = new UserDAO();
		for (int i = 0; i < quantity; i++) {
			User user = User.randomUser();
			userDAO.save(user);
		}
	}

	public static void insertCards(int quantity) {
		CardDAO cardDAO = new CardDAO();
		for (int i = 0; i < quantity; i++) {
			Card card = Card.randomCard();
			cardDAO.save(card);
		}
	}

	public static void insertTraces(int quantity) {
		TraceDAO traceDAO = new TraceDAO();
		for (int i = 0; i < quantity; i++) {
			Trace trace = Trace.randomTrace();
			traceDAO.save(trace);
		}
	}

	public static void insertSubscriptions(int quantity) {
		PassDAO subscriptionDAO = new PassDAO();
		for (int i = 0; i < quantity; i++) {
			Subscription subscription = Subscription.randomSubscription();
			subscriptionDAO.save(subscription);
		}
	}

	public static void insertReseller(int quantity) {
		ResellerDAO resellerDAO = new ResellerDAO();
		for (int i = 0; i < quantity; i++) {
			if (i % 2 == 0) {
				Reseller reseller = Reseller.randomReseller();
				resellerDAO.save(reseller);
			} else {
				VendingMachine machine = VendingMachine.randomVendingMachine();
				resellerDAO.save(machine);
			}

		}
	}

}

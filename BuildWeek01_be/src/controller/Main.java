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
import enumerates.TypeSubscription;

public class Main {

	public static void main(String[] args) {
		//insertReseller(300);
		UserDAO userDAO = new UserDAO();
		CardDAO cardDAO = new CardDAO();
		User user = User.randomUser();
		Card card = new Card(LocalDate.now());
		VendingMachine machine = VendingMachine.randomVendingMachine();
		Subscription subscription = Subscription.randomSubscription();
		
		Reseller r1 = new Reseller("FRANCO");
		ResellerDAO rs = new ResellerDAO();
		rs.save(r1);
		
		Subscription subscription2 = new Subscription ("s1","descrizione1", 200.00, r1, TypeSubscription.MONTHLY  );
		PassDAO  ps = new PassDAO();
		ps.save(subscription2);
		System.out.println("SUB " + subscription2);
		
		
		card.addSubscription(subscription2);
		userDAO.save(user);
		card.setUser(user);
		cardDAO.save(card);
		System.out.println(card);
		System.out.println(machine);
		
		
		cardDAO.verificaValidita(1);
		
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

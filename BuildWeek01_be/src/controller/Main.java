package controller;

import models.Trace;
import models.User;
import models.Card;
import models.Pass;
import models.Reseller;
import models.Subscription;
import models.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dao.CardDAO;
import dao.PassDAO;
import dao.ResellerDAO;
import dao.TraceDAO;
import dao.UserDAO;
import enumerates.TypeSubscription;

public class Main {

	public static void main(String[] args) {
		Reseller reseller1 = new Reseller("franco");
		Reseller reseller2 = new Reseller("marco");
		Ticket ticket1 = Ticket.randomTicket();
		Ticket ticket2 = Ticket.randomTicket();
		ResellerDAO resellerDAO = new ResellerDAO();
		PassDAO pd1 = new PassDAO();
		
		resellerDAO.save(reseller1);
		
		//Ticket tt1 = new Ticket("ciao", "stoca", 18.2, reseller2, false);
		Subscription s1 = new Subscription("abbonamento 1", "Lombardia", 1300.2, reseller1, TypeSubscription.MONTHLY);
		pd1.save(s1);
		
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

	/*
	 * public static void insertSubscriptions(int quantity) {
	 * PassDAO subscriptionDAO = new PassDAO();
	 * CardDAO cardDAO = new CardDAO();
	 * List<Card> cards = cardDAO.getAll();
	 * for (int i = 0; i < quantity; i+=2) {
	 * Subscription subscription = Subscription.randomSubscription();
	 * 
	 * subscriptionDAO.save(subscription);
	 * }
	 * }
	 */
}

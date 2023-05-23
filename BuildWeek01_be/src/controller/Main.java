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

public class Main {

	public static void main(String[] args) {
		insertUsers(50);
		insertCards(10);
		CardDAO cardDAO = new CardDAO();
		Card card = cardDAO.getById(1);
		Subscription subscription = Subscription.randomSubscription();
		card.addSubscription(subscription);
		cardDAO.update(card);
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

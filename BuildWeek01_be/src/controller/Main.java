package controller;
import models.Trace;
import models.User;
import models.Card;
import models.Subscription;
import models.Ticket;

import java.util.List;
import java.util.Random;

import dao.CardDAO;
import dao.UserDAO;

public class Main {

	public static void main(String[] args) {
		UserDAO userDAO = new UserDAO();
		Card card = Card.randomCard();
		User user = new User();
		user.setName("Mario Rossi");
		user.setCard(card);
		card.setUser(user); // imposta il riferimento inverso nella classe Card
		userDAO.save(user); // salva l'utente e la carta
	}

	public static void insertUsers(int quantity) {
		UserDAO userDAO = new UserDAO();
		for(int i=0; i<quantity; i++) {
			User user = User.randomUser();
			userDAO.save(user);
		}
	}

	public static void insertCards(int quantity) {
		CardDAO cardDAO = new CardDAO();
		for(int i=0; i<quantity; i++) {
			Card card = Card.randomCard();
			cardDAO.save(card);
		}
	}

	public static void randomUserTest() {
		User u = User.randomUser();
		System.out.println(u);
	}

	public static void randomSubscriptionTest() {
		Subscription subscription = Subscription.randomSubscription();
		System.out.println(subscription);
	}

	public static void randomTicketTest() {
		Ticket ticket = Ticket.randomTicket();
		System.out.println(ticket);
	}

	public static void randomTraceTest() {
		Trace trace = Trace.randomTrace();
		System.out.println(trace);
	}

	public static void cardDAOTEst() {
		CardDAO cardDAO = new CardDAO();
		cardDAO.saveAll(List.of(
				Card.randomCard(), Card.randomCard(), Card.randomCard()
		));
	}

	public static void randomCardTest() {
		Card card = Card.randomCard();
		System.out.println(card);
	}
}

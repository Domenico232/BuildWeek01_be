package controller;
import models.Trace;
import models.User;
import models.Card;
import models.Subscription;
import models.Ticket;

import java.util.List;

import dao.CardDAO;

public class Main {

	public static void main(String[] args) {
		User u = new User();
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
}

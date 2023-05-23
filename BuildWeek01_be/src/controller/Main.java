package controller;
import models.Ticket;
import models.Trace;
import models.Card;
import models.Subscription;

import java.util.List;

import DAO.CardDAO;

public class Main {

	public static void main(String[] args) {
        System.out.println("Hello World!");
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

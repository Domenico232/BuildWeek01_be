package controller;
import models.Trace;
import models.User;
import models.Card;
import models.Reseller;
import models.Subscription;
import models.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dao.CardDAO;
import dao.UserDAO;

public class Main {

	public static void main(String[] args) {
		Reseller r1 = new Reseller("franco");
		
		
//		List <Ticket> lt1 = new ArrayList();
//		lt1.add(t1);
//		lt1.add(t2);
//		lt1.add(t3);
		
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
				Card.randomCard(), Card.randomCard(), Card.randomCard()
		));
	}

	public static void randomCardTest() {
		Card card = Card.randomCard();
		System.out.println(card);
	}
	
//	public static void cardDAOTEst() {
//		CardDAO cardDAO = new CardDAO();
//		cardDAO.saveAll(List.of(
//				Card.randomCard(), Card.randomCard(), Card.randomCard()
//		));
//	}
}

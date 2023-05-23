package controller;
import models.Ticket;
import models.Trace;
import models.Card;
import models.Reseller;
import models.Subscription;

import java.util.ArrayList;
import java.util.List;

import DAO.CardDAO;
import DAO.TicketDAO;

public class Main {

	public static void main(String[] args) {

		Reseller r1 = new Reseller("franco");
		Ticket t1 = new Ticket("t1", "roma", 10.5, r1, null);
		Ticket t2 = randomTicketTest();
		Ticket t3 = randomTicketTest();
		TicketDAO td1 = new TicketDAO();
		td1.save(t1);
		
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

//	public static void cardDAOTEst() {
//		CardDAO cardDAO = new CardDAO();
//		cardDAO.saveAll(List.of(
//				Card.randomCard(), Card.randomCard(), Card.randomCard()
//		));
//	}
}

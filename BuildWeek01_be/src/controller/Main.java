package controller;

import models.Trace;
import models.Tram;
import models.User;
import models.VendingMachine;
import models.Bus;
import models.Card;
import models.Pass;
import models.Reseller;
import models.Subscription;
import models.Ticket;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import dao.CardDAO;
import dao.PassDAO;
import dao.ResellerDAO;
import dao.TraceDAO;
import dao.UserDAO;
import enumerates.TypeStatus;
import enumerates.TypeSubscription;

public class Main {

	public static void main(String[] args) {
		//insertReseller(300);
		UserDAO userDAO = new UserDAO();
		CardDAO cardDAO = new CardDAO();
		User user = User.randomUser();
		Card card = new Card(LocalDate.now());
		Subscription subscription = Subscription.randomSubscription();
		
		Reseller r1 = new Reseller("FRANCO");
		Reseller r2 = new Reseller("GIANNI");
		ResellerDAO rs = new ResellerDAO();
		rs.save(r1);
		rs.save(r2);
		
		User u1 = new User("Sergio", "Mattarella");
		userDAO.save(u1);
		Subscription subscription2 = new Subscription ("s1","descrizione1", 200.00, r1, TypeSubscription.MONTHLY  );
		Subscription subscription3 = new Subscription ("s2","descri2", 200.00, r2, TypeSubscription.MONTHLY  );
		PassDAO  ps = new PassDAO();
		ps.save(subscription3);
		System.out.println("SUB " + subscription2);
		System.out.println("__________________________");
		Card c = new Card(LocalDate.of(2023, 3, 1), u1);
		cardDAO.save(c);
				
		System.out.println("__________________________");

		List<Pass> prova = ps.listaTotPass(2, LocalDate.of(2023, 5, 23),  LocalDate.of(2023, 5, 24));
		prova.forEach(e -> System.out.println(e));
		
		System.out.println("__________________________");
		
		//cardDAO.save(card);
		ps.save(subscription2);
		c.addSubscription(subscription2);
		userDAO.save(user);
		cardDAO.update(c);
		
		System.out.println("provaaaaaaaaaaaa__________________________");
		cardDAO.verificaValidita(1, 2);
		System.out.println("__________________________");
		
		
		insertTraces(1);
		Tram tram = new Tram();
		tram.setTypeStatus(TypeStatus.SERVIZIO);
		Bus bus = new Bus();
		bus.setTypeStatus(TypeStatus.MANUTENZIONE);
		

		
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
			System.out.println(trace);
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

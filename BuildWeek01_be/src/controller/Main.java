package controller;

import models.Trace;
import models.TraceTraveled;
import models.Tram;
import models.User;
import models.Veicle;
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
import java.util.Random;

import dao.CardDAO;
import dao.PassDAO;
import dao.ResellerDAO;
import dao.TraceDAO;
import dao.TraceTraveledDAO;
import dao.UserDAO;
import dao.VeicleDAO;
import enumerates.TypeStatus;
import enumerates.TypeSubscription;

public class Main {

	public static void main(String[] args) {
		// insertReseller(300);
		UserDAO userDAO = new UserDAO();
		CardDAO cardDAO = new CardDAO();
		User user = User.randomUser();
		Card card = new Card(LocalDate.now(), user); // aggiunto user OCCHIO
		Subscription subscription = Subscription.randomSubscription();

		Reseller r1 = new Reseller("FRANCO");
		Reseller r2 = new Reseller("GIANNI");
		ResellerDAO rs = new ResellerDAO();
		rs.save(r1);
		rs.save(r2);

		User u1 = new User("Sergio", "Mattarella");
		userDAO.save(u1);
		Subscription subscription2 = new Subscription("s1", "descrizione1", 200.00, r1, TypeSubscription.MONTHLY);
		Subscription subscription3 = new Subscription("s2", "descri2", 200.00, r2, TypeSubscription.MONTHLY);
		PassDAO ps = new PassDAO();
		ps.save(subscription3);
		System.out.println("SUB " + subscription2);
		System.out.println("__________________________");
		Card c = new Card(LocalDate.of(2023, 3, 1), u1);
		cardDAO.save(c);

		System.out.println("__________________________");

		List<Pass> prova = ps.listaTotPass(2, LocalDate.of(2023, 5, 23), LocalDate.of(2023, 5, 24));
		prova.forEach(e -> System.out.println(e));

		System.out.println("__________________________");

		// cardDAO.save(card);
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

	public static void run() {
		insertUsers(15);
		insertCards(10);
		insertResellers(5);
		insertSubscriptions(50);
		insertTraces(50);
		insertTickets(10);
		insertVeicles(5);
		insertTracesTraveled(20);
		insertTicketsInBuses();
		CardDAO cardDAO = new CardDAO();
		Card card = cardDAO.getById(1);
		System.out.println(card.getSubscriptions());
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
		CardDAO cardDAO = new CardDAO();
		PassDAO passDAO = new PassDAO();
		for (int i = 0; i < quantity; i++) {
			Subscription subscription = Subscription.randomSubscription();
			passDAO.save(subscription);
			Card card = subscription.getCard();
			card.addSubscription(subscription);
			cardDAO.update(card);
		}
	}

	public static void insertTickets(int quantity) {
		PassDAO passDAO = new PassDAO();
		for (int i = 0; i < quantity; i++) {
			Ticket ticket = Ticket.randomTicket();
			passDAO.save(ticket);
		}
	}

	public static void insertResellers(int quantity) {
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

	public static void insertVeicles(int quantity) {
		VeicleDAO busDAO = new VeicleDAO();
		for (int i = 0; i < quantity; i++) {
			if (i % 2 == 0) {
				Tram tram = Tram.randomTram();
				busDAO.save(tram);
			} else {
				Bus bus = Bus.randomBus();
				busDAO.save(bus);
			}
		}
	}

	public static void insertTicketsInBuses() {
		PassDAO passDAO = new PassDAO();
		VeicleDAO veicleDAO = new VeicleDAO();
		List<Pass> tickets = passDAO.getTicketsNotEndorsed();
		if (tickets == null) {
			System.out.println("All tickets are not endorsed");
		}
		List<Veicle> veicles = veicleDAO.getVeiclesInService();
		if (veicles == null) {
			System.out.println("All veicles are out of service");
		}
		Random rand = new Random();
		for (int i = 0; i < tickets.size(); i += 3) {
			Ticket ticket = (Ticket) tickets.get(i);
			Veicle veicle = veicles.get(rand.nextInt(veicles.size()));
			ticket.setEndorsed(true);
			ticket.setVeicle(veicle);
			veicle.addTicket(ticket);
			passDAO.update(ticket);
			veicleDAO.update(veicle);
		}
	}

	public static void insertTracesTraveled(int quantity) {
		TraceTraveledDAO traceTraveledDAO = new TraceTraveledDAO();
		for (int i = 0; i < quantity; i++) {
			TraceTraveled traceTraveled = TraceTraveled.randomTraceTraveled();
			if (traceTraveled != null) {
				traceTraveledDAO.save(traceTraveled);
			} else {
				System.out.println("TraceTraveled is null");
			}
		}

	}
}

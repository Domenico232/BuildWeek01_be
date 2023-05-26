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
import java.util.List;
import java.util.Random;

import dao.CardDAO;
import dao.PassDAO;
import dao.ResellerDAO;
import dao.TraceDAO;
import dao.TraceTraveledDAO;
import dao.UserDAO;
import dao.VeicleDAO;

public class Main {

	public static void main(String[] args) {
		 VeicleDAO veicleDAO = new VeicleDAO();
		run();
		 System.out.println("Numero di biglietti vidimati dal veicolo"+ " "+veicleDAO.getNumberOfTicketsByVeicleId(2));
		System.out.println("********** END **********");
	}

	public static void run() {
		insertUsers(150);
		insertResellers(50);
		insertTraces(100);
		insertVeicles(5);
		insertCards(100);
		insertSubscriptions(100);
		insertTickets(150);
		insertTracesTraveled(20);
		insertTicketsInBuses();
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

		for (int i = 0; i < tickets.size(); i += 2) {

			Ticket ticket = (Ticket) tickets.get(i);
			Veicle veicle = veicles.get(rand.nextInt(veicles.size()-1));

			ticket.setEndorsed(true);
			ticket.setVeicle(veicle);

			veicle.addTicket(ticket);
			passDAO.update(ticket);

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

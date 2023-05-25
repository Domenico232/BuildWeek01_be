package controller;

import models.Trace;
import models.TraceTraveled;
import models.Tram;
import models.User;
import models.Veicle;
import models.VendingMachine;
import models.Bus;
import models.Card;
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

		insertUsers(100);
		insertCards(15);
		insertTraces(50);
		insertBuses(5);
		insertTimeTraveled(100);
		insertReseller(20);
		insertTickets(300);
		
		// System.out.println(Tram.randomTram());
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
		List<Card> cards = cardDAO.getAll();
		for (int i = 0; i < quantity; i++) {
			Subscription subscription = Subscription.randomSubscription();
			Card card = cards.get(i % quantity + 1);
			card.addSubscription(subscription);
		}
	}
	
	public static void insertTickets(int quantity) {
		PassDAO passDAO = new PassDAO();
		for (int i = 0; i < quantity; i++) {
			Ticket ticket = Ticket.randomTicket();
			passDAO.save(ticket);
			
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

	public static void insertBuses(int quantity) {
		VeicleDAO busDAO = new VeicleDAO();
		for (int i = 0; i < quantity; i++) {
			Bus bus = Bus.randomBus();
			busDAO.save(bus);
		}
	}
	public static void insertTicketsinBuses(){
		
	}
	

	public static void insertTimeTraveled(int quantity) {
		TraceTraveledDAO timeTraveledDAO = new TraceTraveledDAO();
		VeicleDAO veicleDAO = new VeicleDAO();
		List<Veicle> veicles = veicleDAO.getAll();
		System.out.println(veicles);
		Random rand = new Random();
		for (int i = 0; i < quantity; i++) {
			TraceTraveled traceTraveled = TraceTraveled.randomTraceTraveled(rand.nextInt(veicles.size())+1);
			timeTraveledDAO.save(traceTraveled);
		}

	}
}

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
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.internal.build.AllowSysOut;

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

	static CardDAO cardDAO = new CardDAO();
	static PassDAO passDAO = new PassDAO();
	static VeicleDAO veicleDAO = new VeicleDAO();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		run();
		System.out.println("********** END **********");
	}

	public static void operationSystem() {
		System.out.println("Sistema gestionale di azienda di autotrasporti");
		System.out.println();
		System.out.println("Inserisci il numero della ricerca che vuoi effettuare: ");
		System.out.println(" 1 - Abbonamenti attivi inserendo un numero di tessera ");
		System.out.println(" 2 - Biglietti vidimati su un mezzo");
		System.out.println(" 3 - Bigletti vidimati in un lasso di tempo");
		System.out.println(" 4 - Biglietti venduti da un venditore in un lasso di tempo");
		int number = sc.nextInt();

		switch (number) {
			case (1): {
				System.out.println("Inserisci il numero di tessera da verificare");
				int choice = sc.nextInt();
				Card card = cardDAO.getById(choice);
				Set<Subscription> subscriptions = card.getSubscriptions();
				for (Subscription subscription : subscriptions) {
					if (subscription.isValid()) {
						System.out.println("L'abbonamento numero: " + subscription.getId() + " è valido");
					} else {
						System.out.println("L'abbonamento numero: " + subscription.getId() + " è scaduto");
					}
				}
				break;
			}
			case (2): {
				System.out.println("Inserisci il numero del mezzo:");
				int choice = sc.nextInt();
				System.out.println("Numero di biglietti vidimati dal veicolo " + choice + ": "
						+ veicleDAO.getNumberOfTicketsByVeicleId(choice));
				break;
			}
			case (3): {
				System.out.println("Inserisci la data di partenza ");
				System.out.println("---------------------------------");
				System.out.println("Inserisci l'anno: ");
				int anno1 = sc.nextInt();
				System.out.println("Inserisci il mese: ");
				int mese1 = sc.nextInt();
				System.out.println("Inserisci il giorno: ");
				int giorno1 = sc.nextInt();
				System.out.println("Inserisci la data di fine ");
				System.out.println("---------------------------------");
				System.out.println("Inserisci l'anno: ");
				int anno2 = sc.nextInt();
				System.out.println("Inserisci il mese: ");
				int mese2 = sc.nextInt();
				System.out.println("Inserisci il giorno: ");
				int giorno2 = sc.nextInt();
				System.out.println(passDAO.getEndorsedTicketsInTimeRange(LocalDate.of(anno1, mese1, giorno1),
						LocalDate.of(anno2, mese2, giorno2)));
				break;
			}
			case (4): {
				System.out.println("Inserisci il codice del venditore: ");
				int venditore = sc.nextInt();
				System.out.println("Inserisci la data di partenza ");
				System.out.println("---------------------------------");
				System.out.println("Inserisci l'anno: ");
				int anno3 = sc.nextInt();
				System.out.println("Inserisci il mese: ");
				int mese3 = sc.nextInt();
				System.out.println("Inserisci il giorno: ");
				int giorno3 = sc.nextInt();
				System.out.println("Inserisci la data di fine: ");
				System.out.println("Inserisci l'anno: ");
				int anno4 = sc.nextInt();
				System.out.println("Inserisci il mese: ");
				int mese4 = sc.nextInt();
				System.out.println("Inserisci il giorno: ");
				int giorno4 = sc.nextInt();
				List<Pass> prova = passDAO.getPassFromSeller(venditore, LocalDate.of(anno3, mese3, giorno3),
						LocalDate.of(anno4, mese4, giorno4));
				prova.forEach(e -> System.out.println(e));
				break;
			}
			default:
				System.out.println("Errore nella dicitura, ti invitiamo a riprovare!");
				operationSystem();
		}
		sc.close();
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
			Veicle veicle = veicles.get(rand.nextInt(veicles.size()));

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

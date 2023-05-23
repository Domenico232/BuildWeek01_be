package test;

import models.Ticket;

public class TicketTest {
    public static void main(String[] args) {
        Ticket ticket = Ticket.randomTicket();
        System.out.println(ticket);
    }
}

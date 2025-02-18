// Anshul Gaur 22bcs13276

import java.util.Random;

class TicketSystem {
    private int availableSeats;

    public TicketSystem(int seats) {
        this.availableSeats = seats;
    }

    public synchronized void bookSeat(String passenger, int seats) {
        if (seats <= availableSeats) {
            System.out.println("🎟️ " + passenger + " successfully booked " + seats + " seat(s).");
            availableSeats -= seats;
        } else {
            System.out.println("❌ " + passenger + " failed to book. Not enough seats!");
        }
    }
}

class Passenger extends Thread {
    private final TicketSystem system;
    private final String name;
    private final int requestedSeats;

    public Passenger(TicketSystem system, String name, int requestedSeats, int priority) {
        this.system = system;
        this.name = name;
        this.requestedSeats = requestedSeats;
        setPriority(priority);
    }

    public void run() {
        system.bookSeat(name, requestedSeats);
    }
}

public class UniqueTicketBooking {
    public static void main(String[] args) {
        int totalSeats = 6;
        TicketSystem system = new TicketSystem(totalSeats);
        Random random = new Random();

        Passenger p1 = new Passenger(system, "Eleanor (VIP)", random.nextInt(3) + 1, Thread.MAX_PRIORITY);
        Passenger p2 = new Passenger(system, "Noah", random.nextInt(2) + 1, Thread.NORM_PRIORITY);
        Passenger p3 = new Passenger(system, "Sophia", random.nextInt(3) + 1, Thread.MIN_PRIORITY);
        Passenger p4 = new Passenger(system, "Liam (VIP)", random.nextInt(2) + 1, Thread.MAX_PRIORITY);
        Passenger p5 = new Passenger(system, "Isabella", random.nextInt(2) + 1, Thread.NORM_PRIORITY);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
    }
}

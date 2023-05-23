package models;

import java.sql.Time;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Trace {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
    private String departure;
    private String arrival;
    
    private Time averageTimeTravel;
    
    

    public Trace() {

    }

    public Trace(String departure, String arrival, Time averageTimeTravel) {
        this.id = -1;
        this.departure = departure;
        this.arrival = arrival;
        this.averageTimeTravel = averageTimeTravel;
    }

    public Trace(long id, String departure, String arrival, Time averageTimeTravel ) {
        this.id = id;
        this.departure = departure;
        this.arrival = arrival;
        this.averageTimeTravel = averageTimeTravel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public Time getAverageTimeTravel() {
        return averageTimeTravel;
    }

    public void setAverageTimeTravel(Time averageTimeTravel) {
        this.averageTimeTravel = averageTimeTravel;
    }
    
   

	public String toString() {
        return "Trace{" +
                "id=" + id +
                ", departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                ", averageTimeTravel=" + averageTimeTravel +
                '}';
    }

    public static Trace randomTrace() {
        Random random = new Random();
        String[] cities = { "New York", "Los Angeles", "Chicago", "Houston", "Phoenix" };
        String departure = cities[random.nextInt(cities.length)];
        String arrival = cities[random.nextInt(cities.length)];
        while (arrival.equals(departure)) {
            arrival = cities[random.nextInt(cities.length)];
        }
        long millis = random.nextInt(3600000);
        Time averageTimeTravel = new Time(millis);
        
        return new Trace(departure, arrival, averageTimeTravel );
    }
}

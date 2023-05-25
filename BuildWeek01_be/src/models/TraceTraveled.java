package models;

import java.sql.Time;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.List;
import dao.VeicleDAO;

@Entity
@Table(name = "trace_traveled")
public class TraceTraveled {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "veicle_id")
    private Veicle veicle;

    @ManyToOne
    @JoinColumn(name = "trace_id")
    private Trace trace;

    private Time traveledTime;

    public TraceTraveled() {

    }

    public TraceTraveled(Veicle veicle, Trace trace) {
        this.veicle = veicle;
        this.trace = trace;
        this.setTravelTime();
    }

    public TraceTraveled(Veicle veicle, Trace trace, Time traveledTime) {
        this.veicle = veicle;
        this.trace = trace;
        this.traveledTime = traveledTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Veicle getVeicle() {
        return veicle;
    }

    public void setVeicle(Veicle veicle) {
        this.veicle = veicle;
    }

    public Trace getTrace() {
        return trace;
    }

    public void setTrace(Trace trace) {
        this.trace = trace;
    }

    public Time getTravelTime() {
        return traveledTime;
    }

    public void setTravelTime() {
        Random random = new Random();
        int hours = random.nextInt(24);
        int minutes = random.nextInt(60);
        int seconds = random.nextInt(60);
        long millis = (hours * 60 * 60 + minutes * 60 + seconds) * 1000;
        this.traveledTime = new Time(millis);
    }

    public void setTravelTime(Time traveledTime) {
        this.traveledTime = traveledTime;
    }

    public String toString() {
        return "TraceTraveled{" +
                "id=" + id +
                ", veicle=" + veicle.getId() +
                ", trace=" + trace.getId() +
                ", effectiveTraveledTime=" + traveledTime +
                '}';
    }

    public static TraceTraveled randomTraceTraveled() {
        Random rand = new Random();
        VeicleDAO veicleDAO = new VeicleDAO();
        List<Veicle> veicles = veicleDAO.getAll();
        if (veicles == null) {
            System.out.println("Veicles not found");
            return null;
        }
        Veicle randomVeicle = veicles.get(rand.nextInt(veicles.size()));
        List<Trace> traces = randomVeicle.getListTraces();
        if (traces.isEmpty()) {
            System.out.println("Traces not found");
            return null;
        }
        Trace randomTrace = traces.get(rand.nextInt(traces.size()));
        Time effectiveTime = randomTrace.getAverageTimeTravel();
        // Genera un numero casuale tra -15 e 15
        int randomOffset = rand.nextInt(31) - 15;
        // Aggiunge o sottrae il numero casuale dal tempo di viaggio medio della traccia
        effectiveTime = new Time(effectiveTime.getTime() + (randomOffset * 60 * 1000));
        TraceTraveled traceTraveled = new TraceTraveled();
        traceTraveled.setVeicle(randomVeicle);
        traceTraveled.setTrace(randomTrace);
        traceTraveled.setTravelTime(effectiveTime);
        return traceTraveled;
    }
}

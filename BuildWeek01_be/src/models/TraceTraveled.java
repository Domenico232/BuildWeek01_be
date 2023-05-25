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

import dao.TraceTraveledDAO;

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
        return "VeicleTrace{" +
                "id=" + id +
                ", veicle=" + veicle +
                ", trace=" + trace +
                ", traveledTime=" + traveledTime +
                '}';
    }

    public static TraceTraveled randomTraceTraveled() {
        TraceTraveledDAO dao = new TraceTraveledDAO();
        List<Trace> traces = dao.getByVeicleId(1);
        System.out.println(traces); 
        return null;
    }
}

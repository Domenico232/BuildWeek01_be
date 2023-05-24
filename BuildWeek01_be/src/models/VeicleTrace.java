package models;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "veicles_traces")
public class VeicleTrace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "veicle_id")
    private Veicle veicle;

    @ManyToOne
    @JoinColumn(name = "trace_id")
    private Trace trace;

    private Time travelTime;

    public VeicleTrace() {

    }

    public VeicleTrace(Veicle veicle, Trace trace, Time travelTime) {
        this.veicle = veicle;
        this.trace = trace;
        this.travelTime = travelTime;
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
        return travelTime;
    }

    public void setTravelTime(Time travelTime) {
        this.travelTime = travelTime;
    }

    public String toString() {
        return "VeicleTrace{" +
                "id=" + id +
                ", veicle=" + veicle +
                ", trace=" + trace +
                ", travelTime=" + travelTime +
                '}';
    }
}

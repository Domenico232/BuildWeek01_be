package models;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import enumerates.TypeStatus;

@Entity
@Table(name = "veicles_status_time")
public class VeicleStatusTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "veicle_id", nullable = false)
    private Veicle veicle;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TypeStatus typeStatus;

    @Column(nullable = false)
    private int days;

    public VeicleStatusTime() {

    }

    public VeicleStatusTime(Veicle veicle, int days) {
        this.veicle = veicle;
        this.typeStatus = veicle.getTypeStatus();
        this.days = days;
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

    public TypeStatus getTypeStatus() {
        return typeStatus;
    }

    public void setTypeStatus(TypeStatus typeStatus) {
        this.typeStatus = typeStatus;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "VeicleStatusTime{" +
                "id=" + id +
                ", veicle=" + veicle +
                ", typeStatus=" + typeStatus +
                ", days=" + days +
                '}';
    }

}

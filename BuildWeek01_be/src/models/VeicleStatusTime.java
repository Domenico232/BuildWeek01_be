package models;

import java.time.LocalDate;

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

import java.time.temporal.ChronoUnit;

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

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "elapsed_days", nullable = false)
    private int elapsedDays;

    public VeicleStatusTime() {

    }

    public VeicleStatusTime(Veicle veicle) {
        this.veicle = veicle;
        this.endDate = LocalDate.now();
        this.typeStatus = veicle.getTypeStatus();
    }

    public VeicleStatusTime(long id, Veicle veicle) {
        this.id = id;
        this.veicle = veicle;
        this.endDate = LocalDate.now();
        this.typeStatus = veicle.getTypeStatus();
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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setElapsedDays() {
        this.elapsedDays = (int) ChronoUnit.DAYS.between(creationDate, endDate);
    }

    public int getElapsedDays() {
        return elapsedDays;
    }

    public void setElapsedDays(int elapsedDays) {
        this.elapsedDays = elapsedDays;
    }

    @Override
    public String toString() {
        return "VeicleStatusTime [id=" + id + ", veicle=" + veicle +
                ", typeStatus=" + typeStatus + ", creationDate=" +
                creationDate + ", endDate=" + endDate + ", elapsedDays="
                + elapsedDays + "]";
    }

}

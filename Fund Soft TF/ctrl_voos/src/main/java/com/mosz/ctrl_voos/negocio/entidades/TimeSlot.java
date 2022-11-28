package com.mosz.ctrl_voos.negocio.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "timeslot")
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "aerovia_id", nullable = true)
    private Aerovia aerovia;
    private String data;
    private String timeSlots;

    public TimeSlot(String data, String timeSlots) {
        this.data = data;
        this.timeSlots = timeSlots;
    }

    public TimeSlot() {
    }

    public void setAerovia(Aerovia aerovia) {
        this.aerovia = aerovia;
    }

    public String getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public String getTimeSlots() {
        return timeSlots;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTimeSlots(String timeSlots) {
        this.timeSlots = timeSlots;
    }
}

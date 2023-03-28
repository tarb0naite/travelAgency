package lt.viko.eif.ktarbonaite.travelagency.model;

import javax.persistence.*;
import javax.security.auth.Subject;
import java.util.List;

@Entity
@Table(name = "offer")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String name;
    private int cost;

    @OneToOne(targetEntity = Trip.class, cascade = CascadeType.ALL)
    private Trip trip;

    public Offer() {

    }

    public Offer(int id, String name, int cost, Trip trip) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.trip = trip;
    }

    public Offer(String name, int cost, Trip trip) {

        this.name = name;
        this.cost = cost;
        this.trip = trip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    @Override
    public String toString() {
        return String.format("Offer: %s" +
                        "Discount = %s" +
                        "Our offer to you = %s",
                this.name,
                this.cost,
                this.trip);
    }
}

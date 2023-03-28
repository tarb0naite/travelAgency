package lt.viko.eif.ktarbonaite.travelagency.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import javax.persistence.*;

@XmlRootElement
@XmlType(propOrder = {"id", "userName", "password", "offer", "trip"})
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String userName;
    private String password;

    public Account() {

    }

    @OneToOne(targetEntity = Trip.class, cascade = CascadeType.ALL)
    private Trip trip;

    @OneToOne(targetEntity = Offer.class, cascade = CascadeType.ALL)
    private Offer offer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Account(int id, String userName, String password, Offer offer, Trip trip) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.offer = offer;
        this.trip = trip;

    }

    public Account(String userName, String password, Offer offer, Trip trip) {

        this.userName = userName;
        this.password = password;
        this.offer = offer;
        this.trip = trip;

    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    @Override
    public String toString() {
        return String.format("Account 1:\n" +
                        "\t\tUsername = %s\n" +
                        "\t\tPassword = %s\n" +
                        "\t\tTrip: %s\n",

                this.userName,
                this.password,
                this.trip);
    }
}


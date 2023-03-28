package lt.viko.eif.ktarbonaite.travelagency.model;

import javax.persistence.*;

@Entity
@Table(name = "trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;


@Enumerated(EnumType.STRING)
    private Type type;
    private int cost;

    @OneToOne(targetEntity = Transport.class, cascade = CascadeType.ALL)
    private Transport transport;
    private String destination;

    @OneToOne(targetEntity = Accommodation.class, cascade = CascadeType.ALL)
    private Accommodation accommodation;

    public Trip() {

    }

    public Trip(int id, Type type, int cost, Transport transport, String destination, Accommodation accommodation) {
        this.id = id;
        this.type = type;
        this.cost = cost;
        this.transport = transport;
        this.destination = destination;
        this.accommodation = accommodation;
    }

    public Trip(Type type, int cost, Transport transport, String destination, Accommodation accommodation) {

        this.type = type;
        this.cost = cost;
        this.transport = transport;
        this.destination = destination;
        this.accommodation = accommodation;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    @Override
    public String toString() {
        return String.format(
                "\n\t\t\tType = %s\n\t" +
                        "\t\tCost = %d£\n" +
                        "\t\t\tTransport:\n %s" +
                        "\t\tDestination:\n\t\t\t\t %s" +
                        "\n\tAccommodation: %s",
                this.type.getValue(),
                this.cost,
                this.transport,
                this.destination,
                this.accommodation);

    }
}

package lt.viko.eif.ktarbonaite.travelagency.model;

import javax.persistence.*;

@Entity
@Table(name = "transport")
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String name;

    public Transport() {

    }

    public Transport(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Transport(String name) {

        this.name = name;
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

    @Override
    public String toString() {
        return String.format("\t\t\tTraveling by = %s\n\t",
                this.name);
    }
}

package lt.viko.eif.ktarbonaite.travelagency.model;

import javax.persistence.*;

@Entity
@Table(name = "accomodation")
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String placeName;

    public Accommodation() {

    }

    public Accommodation(int id, String placeName) {
        this.id = id;
        this.placeName = placeName;
    }

    public Accommodation(String placeName) {

        this.placeName = placeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    @Override
    public String toString() {
        return String.format("\n\t\tThe place to stay at = %s",
                this.placeName);
    }
}

package lt.viko.eif.ktarbonaite.travelagency.model;

public enum Type {
    SUMMER("Summer type trip"),
    WINTER("Winter type trip"),
    RELAXING("For relaxation");



    private String value;


    Type(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}

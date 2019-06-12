package nl.inholland.model;

public class Numbers {

    Integer number;

    public Numbers(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Number{" +
                "number='" + number + '\'' +
                '}';
    }

}

package app.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "autos")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    @Column(name = "license plate")
    private int plate;
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Auto() {
    }

    public Auto(String model, int plate, String color) {
        this.model = model;
        this.plate = plate;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPlate() {
        return plate;
    }

    public void setPlate(int plate) {
        this.plate = plate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auto)) return false;
        Auto auto = (Auto) o;
        return plate == auto.plate &&
                Objects.equals(model, auto.model) &&
                Objects.equals(color, auto.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, plate, color);
    }

    @Override
    public String toString() {
        return "Auto{" +
                "model='" + model + '\'' +
                ", plate=" + plate +
                ", color='" + color + '\'' +
                '}';
    }
}

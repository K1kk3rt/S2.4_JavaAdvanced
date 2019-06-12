package nl.k1kk3rt.model;

import javax.persistence.*;

@Entity
public class Points {

    @Id
    @SequenceGenerator(name = "points_seq", initialValue = 001)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "points_seq")
    private Long id;

    @OneToOne
    private Patrol patrol;

    private Integer points;

    //construct
    private Points() {}

    public Points(Patrol patrol, Integer points) {
        this.patrol = patrol;
        this.points = points;
    }

    @Override
    public String toString() {
        return "Points{" +
                "id=" + id +
                ", patrol=" + patrol +
                ", points=" + points +
                '}';
    }

    //setters
    public void setPatrol(Patrol patrol) {
        this.patrol = patrol;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    //getters
    public Patrol getPatrol() {
        return patrol;
    }

    public Long getId() {
        return id;
    }

    public Integer getPoints() {
        return points;
    }
}

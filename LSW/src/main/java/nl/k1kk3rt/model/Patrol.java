package nl.k1kk3rt.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"groupName"})})
public class Patrol {

    @OneToOne
    private Points points;

    @Id
    @SequenceGenerator(name="patrol_seq", initialValue = 001)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patrol_seq")
    private Long id;
    @NotNull
    private String groupName;

    //construct
    public Patrol(String groupName) {
        this.groupName = groupName;
    }


    public Patrol() {}

    @Override
    public String toString() {
        return "Patrol{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                '}';
    }

    //setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    //getters
    public Long getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }
}


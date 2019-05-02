package dev.eugenie.model;

public class Rsw {
    private Integer id;
    private String group;
    private Integer score;

    //construct
    public Rsw(Integer id, String group, Integer score) {
        this.id = id;
        this.group = group;
        this.score = score;
    }

    public Rsw() {}

    //getters
    public Integer getId() {
        return id;
    }

    public String getGroup() {
        return group;
    }

    public Integer getScore() {
        return score;
    }

    //setters
    public void setGroup(String group) {
        this.group = group;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Rsw{" +
                "id='" + id + '\'' +
                ", group='" + group + '\'' +
                ", score='" + score + '\'' +
                '}';
    }

}

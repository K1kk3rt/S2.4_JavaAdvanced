package model;

public class Patrol {

    private Integer id;
    private Integer points;
    private Integer patrolNum;
    private String patrolName;
    private String city;
    private String group;

    public Patrol(Integer id, Integer points, Integer patrolNum, String patrolName, String city, String group) {
        this.id = id;
        this.points = points;
        this.patrolNum = patrolNum;
        this.patrolName = patrolName;
        this.city = city;
        this.group = group;
    }

    public Patrol() {
    }

    @Override
    public String toString() {
        return "Patrol{" +
                "id='" + id + '\'' +
                ", points='" + points + '\'' +
                ", patrolNum='" + patrolNum + '\'' +
                ", patrolName='" + patrolName + '\'' +
                ", city='" + city + '\'' +
                ", group='" + group + '\'' +
                '}';
    }


    //getters
    public Integer getId() {
        return id;
    }

    public Integer getPoints() {
        return points;
    }

    public Integer getPatrolNum() {
        return patrolNum;
    }

    public String getPatrolName() {
        return patrolName;
    }

    public String getCity() {
        return city;
    }

    public String getGroup() {
        return group;
    }

    //setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public void setPatrolNum(Integer patrolNum) {
        this.patrolNum = patrolNum;
    }

    public void setPatrolName(String patrolName) {
        this.patrolName = patrolName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}

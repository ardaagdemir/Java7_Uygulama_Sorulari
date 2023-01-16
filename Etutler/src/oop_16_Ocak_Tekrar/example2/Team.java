package oop_16_Ocak_Tekrar.example2;

public class Team {

    //Soccer Team
    private String name;
    private int point;
    private double earning;

    public Team(String name) {
        this.name = name;
    }

    public Team(String name, int point, double earning) {
        this.name = name;
        this.point = point;
        this.earning = earning;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public double getEarning() {
        return earning;
    }

    public void setEarning(double earning) {
        this.earning = earning;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", point=" + point +
                ", earning=" + earning +
                '}';
    }
}

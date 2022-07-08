package models;

public class Player {
    private String name;

    private Integer score = 0;

    public Player(String name ){
        this.name = name;

    }


    public String name() {
        return name;
    }

    public Integer score() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void plusScore() {
        this.score++;
    }


}

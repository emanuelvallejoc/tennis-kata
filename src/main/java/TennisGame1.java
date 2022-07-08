import enums.Scores;
import models.Player;

import java.util.Objects;

public class TennisGame1 implements TennisGame {

    private Player firstPlayer;
    private Player secondPlayer;

    private static final String SEPARATOR ="-";
    private static final String ALL ="All";
    private static final String ADVANTAGE = "Advantage %s";
    private static final String WIN_FOR="Win for %s";
    private static final String FIRST_PLAYER="player1";
    private static final String SECOND_PLAYER="player2";
    private static final Integer MINIMUM_POINTS = 4;




    public TennisGame1(String firstPlayerName, String secondPlayerName) {
        this.firstPlayer= new Player(firstPlayerName);
        this.secondPlayer = new Player(secondPlayerName);
    }

    public void wonPoint(String playerName) {
        this.getPlayer(playerName).plusScore();
    }

    public String getScore() {
        String score ="";
        if (isDraw().equals(Boolean.TRUE)) {
            score = firstPlayer.score() < 3 ? getScoreDraw(firstPlayer.score()).toString() : Scores.DEUCE.getValue();
        }
        else if (Boolean.TRUE.equals(haveMinimumPointsToWin()))
        {
            score = differencePoints();
        }
        else
        {
            score = evaluatesScore(score);
        }
        return score;
    }

    private String  evaluatesScore(String score) {
        var scoreBuider = new StringBuilder(score);
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = firstPlayer.score();
            else { scoreBuider.append("-"); tempScore = secondPlayer.score();}
            scoreBuider.append(getScoresByScore(tempScore));

        }
        return scoreBuider.toString();
    }


    private Player getPlayer(String name){
        return firstPlayer.name().equalsIgnoreCase(name)? firstPlayer : secondPlayer;
    }

    private Boolean isDraw(){
        return Objects.equals(firstPlayer.score(), secondPlayer.score());
    }
    private StringBuilder getScoresByScore(Integer score){
        return Scores.scoresByScore(score);
    }
    private StringBuilder getScoreDraw(Integer score){
        return this.getScoresByScore(score).append(SEPARATOR).append(ALL);
    }

    private Boolean haveMinimumPointsToWin(){
        return  firstPlayer.score()>= MINIMUM_POINTS || secondPlayer.score()>=MINIMUM_POINTS;
    }

    private String differencePoints(){
        var difference = firstPlayer.score()- secondPlayer.score();
        var firstValue = Objects.equals(Math.abs(difference), 1)? ADVANTAGE: WIN_FOR ;
        var format = (difference <0 )? SECOND_PLAYER : FIRST_PLAYER;
       return String.format(firstValue, format);

    }
}

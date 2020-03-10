package bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {
    int throwCounter = 0; //Max 21 pour 10 frames
    int twoThrowBefore = 0;
    int lastThrow = 0;
    int total = 0;
    List<Integer> scorePerThrow = new ArrayList<>();

    void roll2(int score) {
        throwCounter++;
        total += score;
        if (throwCounter % 2 == 1 && lastThrow + twoThrowBefore == 10) { //Cette condition est elle parfaite (non defaillante) pour résumer un spare? => non si le premier jet est 0
            total += score;
        } else if (throwCounter % 2 == 1 && lastThrow == 10 || throwCounter % 2 == 0 && twoThrowBefore == 10) {
            total += score;
        }
        if (score == 10 && throwCounter % 2 == 1) {//strike
            throwCounter++;
        }

        twoThrowBefore = lastThrow;
        lastThrow = score;
    }

    void roll(int score) {
        throwCounter++;
        scorePerThrow.add(score);

        if (score == 10 && throwCounter % 2 == 1 && throwCounter < 19) {//strike
            throwCounter++;
            scorePerThrow.add(-1);
        }
    }

    int score() {
        int strikeBonus = 0;
        int spareBonus = 0;
        for (int turn = 1; turn <= scorePerThrow.size(); turn++) {
            if(scorePerThrow.get(turn - 1) != -1) {
                int throwScore = scorePerThrow.get(turn - 1);
                if (turn < 20 || turn == 20 && scorePerThrow.get(turn - 2) != 10) {
                    total += throwScore;
                }
                if (spareBonus > 0) {
                    total += throwScore;
                    spareBonus--;
                }
                if (strikeBonus > 0 ) {
                    total += throwScore;
                    strikeBonus--;
                    if (strikeBonus > 1) {
                        total += throwScore;
                        strikeBonus--;
                    }
                }
                if (throwScore == 10 && turn % 2 == 1 && turn < 20) {
                    strikeBonus += 2;
                } else if (turn > 1 && turn < 21 && turn % 2 == 0 && throwScore + scorePerThrow.get(turn - 2) == 10) {
                    spareBonus += 1;
                }
            }
        }

        return total;
    }

}

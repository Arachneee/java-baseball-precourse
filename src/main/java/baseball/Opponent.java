package baseball;

import java.util.*;
import static camp.nextstep.edu.missionutils.Randoms.*;

public class Opponent
{
    private static List<Integer> numbers = new ArrayList<>();

    public static void start()
    {
        numbers = pickUniqueNumbersInRange(1,9,3);
    }

    private BallAndStrike countBallAndStrike(Player player)
    {
        List<Integer> playerNubmerList = player.getNumbers();

        int ball = 0;
        int strike = 0;

        for(int i=0;i<3;i++)
        {
            if (playerNubmerList.get(i) == numbers.get(i))
            {
                strike++;
                continue;
            }
            if (numbers.contains(playerNubmerList.get(i)))
                ball++;
        }
        return new BallAndStrike(ball, strike);
    }
}

package baseball.domain;

import java.util.*;
import static camp.nextstep.edu.missionutils.Randoms.*;

public class Opponent
{
    private static List<Integer> numbers = new ArrayList<>();

    public void reset()
    {
        numbers = new ArrayList<>();
        for(int i=0;i<3;i++)
            getUniqueNumbers();
    }
    private void getUniqueNumbers()
    {
        int i = pickNumberInRange(1,9);
        while(numbers.contains(i))
            i = pickNumberInRange(1,9);
        numbers.add(i);
    }

    public BallAndStrike countBallAndStrike(Player player)
    {
        List<Integer> playerNubmerList = player.getNumbers();

        int ball = 0;
        int strike = 0;

        for(int i=0;i<3;i++)
        {
            if (Objects.equals(playerNubmerList.get(i), numbers.get(i)))
            {
                strike++;
                continue;
            }
            if (numbers.contains(playerNubmerList.get(i)))
                ball++;
        }
        return new BallAndStrike(ball, strike);
    }
    public void print()
    {
        System.out.println(numbers);
    }
}

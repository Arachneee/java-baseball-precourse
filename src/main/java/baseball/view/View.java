package baseball.view;


import baseball.domain.BallAndStrike;
import baseball.domain.State;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class View
{
    private String start = "숫자를 입력해주세요 : ";
    private String end = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private String out = "게임 종료";
    private State state = State.CONTINUE;
    public void viewPlayBall()
    {
        System.out.print(start);
    }
    public void viewOut() { System.out.println(out);}
    public void viewResult(BallAndStrike ballAndStrike)
    {
        System.out.println(ballAndStrike.toString());
        if (ballAndStrike.getStrike() == 3)
        {
            System.out.println(end);
            String startNewPlay = readLine();
            if(startNewPlay.equals("1"))
            {
                state = State.RESTART;
                return;
            }

            if(startNewPlay.equals("2"))
            {
                state = State.END;
                return;
            }
            throw new IllegalArgumentException("[ERROR] 1이나 2를 입력하세요.");
        }
        state = State.CONTINUE;
    }

    public State getState()
    {
        return state;
    }
}

package baseball.controller;

import baseball.domain.BallAndStrike;
import baseball.domain.Opponent;
import baseball.domain.Player;
import baseball.domain.State;
import baseball.view.View;

public class BaseBallController
{
    public void run()
    {
        Opponent opponent = new Opponent();
        opponent.reset();

        Player player = new Player();

        View view = new View();

        while (true)
        {
            view.viewPlayBall();
            player.throwBall();
            BallAndStrike ballAndStrike = opponent.countBallAndStrike(player);
            view.viewResult(ballAndStrike);
            if (view.getState() == State.CONTINUE)
                continue;
            if (view.getState() == State.RESTART)
            {
                opponent = new Opponent();
                opponent.reset();
                continue;
            }
            if (view.getState() == State.END)
            {
                view.viewOut();
                break;
            }

        }

    }

}

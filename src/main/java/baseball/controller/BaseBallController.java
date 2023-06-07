package baseball.controller;

import baseball.domain.BallAndStrike;
import baseball.domain.Opponent;
import baseball.domain.Player;
import baseball.domain.State;
import baseball.view.View;


public class BaseBallController
{
    private Opponent opponent;
    private Player player;
    private View view;
    public void run(){
        setOpponent();
        player = new Player();
        view = new View();
        playBall();
    }
    private void setOpponent()
    {
        opponent = new Opponent();
        opponent.reset();
        //opponent.print();
    }

    private void playBall()
    {
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
                System.out.println("restart");
                setOpponent();
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

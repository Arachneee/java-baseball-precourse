package baseball.domain;

public class BallAndStrike
{
    private int ball = 0;
    private int strike = 0;

    public BallAndStrike(int ball,int strike)
    {
        this.ball = ball;
        this.strike = strike;
    }

    public String toString()
    {
        if(ball == 0 && strike == 0)
            return "낫싱";
        if(ball == 0)
            return strike + "스트라이크";
        if(strike == 0)
            return ball + "볼";
        return ball + "볼 " + strike + "스트라이크";
    }
    public int getBall()
    {
        return ball;
    }
    public int getStrike()
    {
        return strike;
    }
}

package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Player
{
    private static List<Integer> numbers = new ArrayList<>();
    public void throwBall()
    {
        String input = Console.readLine();

        if (input.length() != 3)
            throw new IllegalArgumentException("[ERROR] 3개의 공을 던져주세요.");
        for(int i = 0;i<input.length();i++)
        {
            int num = input.charAt(i)-'0';
            if (num <0 || num >9)
                throw new IllegalArgumentException("[ERROR] 1~9의 숫자만 입력해 주세요.");
            if (numbers.contains(num))
                throw new IllegalArgumentException("[ERROR] 중복된 입력이 있습니다.");
            numbers.add(num);
        }
    }

    public List<Integer> getNumbers()
    {
        return numbers;
    }

}

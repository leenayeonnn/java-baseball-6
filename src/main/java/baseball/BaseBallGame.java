package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * BaseBallGame.java
 *
 * 야구게임이 수행될 메인 부분
 *
 * @author Lee NaYeon
 * @since 2023-10-24
 */

public class BaseBallGame {

    public void start(){

        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computer = createRandomNumber();

        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> input = stringToListInt(Console.readLine());

        int[] result = compareAnswerInput(computer, input);


    }

    /**
     * 3자리 난수 생성
     * @return List<Integer> 타입의 3자리 난수
     */
    private List<Integer> createRandomNumber(){

        List<Integer> list = new ArrayList<>();
        while (list.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(randomNumber)) {
                list.add(randomNumber);
            }
        }

        return list;
    }

    /**
     * 문자열을 List<Integer> 타입으로 변경
     * @param str
     * @return List<Integer>타입의 숫자
     */
    private List<Integer> stringToListInt(String str) {
        List<Integer> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                list.add(digit);
            }
        }
        return list;
    }

    /**
     * input값과 정답값을 비교해서 볼, 스트라이크 개수 계산
     *
     * @param ans
     * @param input
     * @return int[] 타입의 비교 결과 (index 0 : 볼, 1 : 스트라이크)
     */
    private int[] compareAnswerInput(List<Integer> ans, List<Integer> input) {

        int[] result = {0, 0};

        for (int i = 0; i < ans.size(); i++) {
            if (ans.get(i).equals(input.get(i))) {
                result[1]++;
            } else if (ans.contains(input.get(i))) {
                result[0]++;
            }
        }

        return result;

    }


}

package ir.dayan.footballmatchproject.utils;

import ir.dayan.footballmatchproject.models.enums.MatchResultEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomUtils {


    //TODO here Should Be Refactored
    public static List<int[]> matchRandomGenerator(List<Integer> numbers) {
        List<int[]> combinations = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                int num1 = numbers.get(i);
                int num2 = numbers.get(j);
                combinations.add(new int[]{num1, num2});
            }
        }
        return combinations;
    }


    public static MatchResultEnum getWinner() {
        return Arrays.asList(MatchResultEnum.values()).get(new Random().nextInt(MatchResultEnum.values().length));
    }

}

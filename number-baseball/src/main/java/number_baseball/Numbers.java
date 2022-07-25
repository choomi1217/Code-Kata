package number_baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Numbers {
    private int firstNumber;
    private int secondNumber;
    private int thirdNumber;

    private Numbers(int firstNumber, int secondNumber, int thirdNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.thirdNumber = thirdNumber;
    }

    public static Numbers of(String numbers) {
        //여기에 랜덤값을 담아주는 메서드가 담기면 되지 않을까엄?
        try {
            validate(numbers);
            int[] ints =
                    Arrays.stream(numbers.split(""))
                            .mapToInt(Integer::parseInt)
                            .toArray();
            return new Numbers(ints[0], ints[1], ints[2]);
        } catch (IllegalArgumentException e) {
            throw e;
            //Numbers.of("랜덤값");
            //여기에 랜덤값을 담아주는 메서드가 담기면 되지 않을까엄?
        }
    }

    private static void validate(String numbers) {
        if (numbers == null || numbers.isBlank()) throw new IllegalArgumentException("빈 값이 오면 안된다.");
        if (numbers.length() != 3) throw new IllegalArgumentException("세 자리만 와야한다.");
        if (!numbers.matches("^\\d{3}")) throw new IllegalArgumentException("숫자만 세 자리가 와야한다.");

        String[] eachNumber = numbers.split("");
        Set<String> collect = Arrays.stream(eachNumber)
                .collect(Collectors.toSet());
        if (collect.size() != 3) throw new IllegalArgumentException("중복되는 숫자는 사용할 수 없습니다.");
    }

    public static String makeRandoms() {
        Set<Integer> integerSet = new HashSet<>();

        if (integerSet.size() != 3) {
            makeRandoms();
        }

        return integerSet.toString();
    }


}

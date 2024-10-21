package problem;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] filteredArray = Arrays.stream(Arrays.stream(arr).filter(number -> number % divisor == 0).toArray()).sorted().toArray();

        if(filteredArray.length == 0) return new int[] {-1};

        return filteredArray;
    }
}

package problem.easy;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Problem19 {

    /**
     * 스트림을 사용하여 문자열 배열에서 TreeMap을 생성합니다.
     * 배열의 각 요소를 key로 하고, 해당 요소의 길이를 value로 하는 TreeMap을 반환합니다.
     *
     * @param strings 문자열 배열
     * @return 생성된 TreeMap
     */
    public static Map<String, Integer> createTreeMapFromStream(String[] strings) {
        // 여기에 코드 작성
        return Arrays.stream(strings)
                .collect(Collectors.toMap(
                        string -> string, // 키: 각 문자열
                        String::length,   // 값: 문자열의 길이
                        (existing, replacement) -> existing, // 중복 키 처리
                        TreeMap::new      // 결과를 TreeMap으로 수집
                ));
    }
}

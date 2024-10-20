package problem.medium;

import java.util.List;
import java.util.stream.Collectors;

import problem.medium.resources.Customer2;
import problem.medium.resources.Order;

public class Problem53 {

    /**
     * 주어진 고객(Customer2) 리스트에서 각 고객별로 주문한 'Milk' 제품의 총 수량을 계산합니다.
     *
     * @param customers 고객 리스트
     * @return 각 고객별 'Milk' 제품의 총 주문 수량을 나타내는 리스트
     */
    public static List<String> getTotalMilkOrdersForEachCustomer(List<Customer2> customers) {
        // 여기에 코드 작성
        return customers.stream()
                .map(customer -> {
                    // 각 고객의 'Milk' 제품 주문 수량 계산
                    int totalMilkOrders = customer.getOrders().stream()
                            .filter(order -> order.getProduct().equals("Milk")) // 'Milk' 제품만 필터링
                            .mapToInt(Order::getQuantity) // 주문 수량 가져오기
                            .sum(); // 총합 계산
                    return customer.getName() + ": " + totalMilkOrders; // 결과 포맷
                })
                .collect(Collectors.toList()); // 결과 리스트로 수집
    }
}

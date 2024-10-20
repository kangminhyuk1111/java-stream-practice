package problem.medium;

import java.util.List;
import java.util.stream.Collectors;

import problem.easy.resources.Customer;
import problem.medium.resources.Customer2;
import problem.medium.resources.Employee;
import problem.medium.resources.Product;

public class Problem60 {

    /**
     * 주어진 고객(Customer) 리스트와 직원(Employee) 리스트를 사용하여,
     * 'IT' 부서 직원들이 주문한 'Electronics' 제품의 총 가격을 계산합니다.
     * 이때, 고객 이름과 직원 이름이 일치하는 경우에만 해당 고객의 주문을 고려합니다.
     *
     * @param customers 고객 리스트
     * @param employees 직원 리스트
     * @param products 제품 리스트 (제품 이름과 가격 정보 포함)
     * @return 'IT' 부서 직원들이 주문한 'Electronics' 제품의 총 가격
     */
    public static double calculateTotalPriceOfElectronicsOrderedByITEmployees(List<Customer2> customers, List<Employee> employees, List<Product> products) {
        // IT 부서 직원의 이름을 추출
        List<String> itEmployeeNames = employees.stream()
                .filter(employee -> employee.getDepartment().equals("IT"))
                .map(Employee::getName)
                .toList();

        // 각 고객의 주문 중 Electronics 제품의 가격을 합산
        return customers.stream()
                .filter(customer -> itEmployeeNames.contains(customer.getName())) // 고객 이름이 IT 직원과 일치하는 경우
                .flatMap(customer -> customer.getOrders().stream()) // 고객의 주문을 스트림으로 변환
                .filter(order -> order.getProduct().equals("Electronics")) // Electronics 제품만 필터링
                .mapToDouble(order -> products.stream() // 해당 제품의 가격을 찾기
                        .filter(product -> product.getName().equals(order.getProduct()))
                        .mapToDouble(Product::getPrice)
                        .findFirst()
                        .orElse(0.0)) // 가격이 없을 경우 0.0 반환
                .sum(); // 가격의 합계 반환
    }
}

package hello.core.order;

public interface OrderService {
    // 주문 결과를 반환한다.(return)
    Order createOrder(Long memberId, String itemName, int itemPrice);
}

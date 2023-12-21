package HoleStuff.Num2Hole;

public class ProductOrderMain {
    public static void main(String[] args) {

        ProductOrder[] orders = new ProductOrder[3];
        orders[0] = createOrder("두부", 1500, 150);
        orders[1] = createOrder("김치", 9000, 200);
        orders[2] = createOrder("콜라", 2000, 350);

        printOrder(orders);
        int totalAmount = getTotalAmount(orders);
        System.out.println("======================================");
        System.out.println("결제금액 : "+ totalAmount);
    }
        static ProductOrder createOrder(String name, int price, int quantity)
        {
            ProductOrder order = new ProductOrder();
            order.name = name;
            order.price = price;
            order.quantity = quantity;

            return order;
        }

        static void printOrder(ProductOrder[] orders) {
            for (ProductOrder order : orders) {
                System.out.println("상품명 : "+ order.name + "가격 : "+order.price+ "수량 :" + order.quantity);
            }
        }

    static int getTotalAmount(ProductOrder[] orders) {
    int totalAmount = 0;
        for (ProductOrder order : orders) {
            totalAmount += order.price * order.quantity;
        }
        return totalAmount;
    }

}

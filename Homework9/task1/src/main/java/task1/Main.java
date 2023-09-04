package task1;

import task1.Order;
import task1.PaymentGateway;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Order order = (Order) context.getBean("order");
        System.out.println(order);

        PaymentGateway paymentGateway = context.getBean(PaymentGateway.class);
        paymentGateway.printInfo();
    }
}

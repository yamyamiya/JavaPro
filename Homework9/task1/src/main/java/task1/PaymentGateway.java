package task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

    public class PaymentGateway {
        @Autowired
        @Qualifier("oldOrder")
        private Order order;

        public void printInfo() {
            System.out.println(order);
        }
    }

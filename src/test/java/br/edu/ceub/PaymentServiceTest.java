package br.edu.ceub;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PaymentServiceTest {

    private Order order;
    private double rawTotal;
    private PaymentService paymentService;

    @BeforeEach
    public void setup() {
        List<OrderItem> items = List.of(
        new OrderItem("Produto A", 60.0, 1),
        new OrderItem("Produto B", 50.0, 2),
        new OrderItem("Produto C", 30.0, 3)
        );
        order = new Order("ORD123", items);
        paymentService = new PaymentService();
        rawTotal = 250;
    }

    @Test 
    void processPaymentVerificaPagamento () {
        assertTrue(paymentService.processPayment(order, rawTotal));
    }

    @Test
    void processPaymentWithoutMoneyReturnFalse () {
        assertFalse(paymentService.processPayment(order, 0));
    }
    
}

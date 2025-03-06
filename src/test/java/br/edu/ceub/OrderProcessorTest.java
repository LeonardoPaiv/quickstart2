package br.edu.ceub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderProcessorTest {

    private Order order;
    private OrderProcessor processor;
    private double rawTotal;

    @BeforeEach
    public void setup() {
        List<OrderItem> items = List.of(
        new OrderItem("Produto A", 60.0, 1),
        new OrderItem("Produto B", 50.0, 2),
        new OrderItem("Produto C", 30.0, 3)
        );
        order = new Order("ORD123", items);
        processor = new OrderProcessor();
        rawTotal = 250;
    }
    
    @Test
    void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    void computeTotalAndReturnRawTotal () {
        double result = processor.computeTotal(order);
        assertEquals(rawTotal, result);
    }
}

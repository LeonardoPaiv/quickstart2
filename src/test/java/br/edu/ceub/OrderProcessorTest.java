package br.edu.ceub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class OrderProcessorTest {

    @Mock
    private DiscountService discountService;

    @Mock
    private InventoryService inventoryService;

    @Mock
    private PaymentService paymentService;

    @Mock
    private OrderRepository repository;

    @Mock
    private EmailService emailService;

    private Order order;
    private OrderProcessor processor;
    private double rawTotal;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        List<OrderItem> items = List.of(
        new OrderItem("Produto A", 60.0, 1),
        new OrderItem("Produto B", 50.0, 2),
        new OrderItem("Produto C", 30.0, 3)
        );
        order = new Order("ORD123", items);
        processor = new OrderProcessor(discountService, inventoryService, paymentService, repository, emailService);
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

    @Test
    void processShouldReturnTrueIfAllServicesReturnedTrue () {
        when(inventoryService.checkInventory(any())).thenReturn(true);
        when(paymentService.processPayment(any(), anyDouble())).thenReturn(true);
        when(repository.saveOrder(any(), anyDouble())).thenReturn(true);
        when(emailService.sendEmail(anyString(), anyString())).thenReturn(true);
        assertTrue(processor.process(order));
    }

    @Test
    void processShouldReturnFalseIfAnyServiceReturnFalse () {
        when(inventoryService.checkInventory(any())).thenReturn(false);
        when(paymentService.processPayment(any(), anyDouble())).thenReturn(true);
        when(repository.saveOrder(any(), anyDouble())).thenReturn(true);
        when(emailService.sendEmail(anyString(), anyString())).thenReturn(true);
        assertFalse(processor.process(order));

        when(inventoryService.checkInventory(any())).thenReturn(true);
        when(paymentService.processPayment(any(), anyDouble())).thenReturn(false);
        when(repository.saveOrder(any(), anyDouble())).thenReturn(true);
        when(emailService.sendEmail(anyString(), anyString())).thenReturn(true);
        assertFalse(processor.process(order));

        when(inventoryService.checkInventory(any())).thenReturn(true);
        when(paymentService.processPayment(any(), anyDouble())).thenReturn(true);
        when(repository.saveOrder(any(), anyDouble())).thenReturn(false);
        when(emailService.sendEmail(anyString(), anyString())).thenReturn(true);
        assertFalse(processor.process(order));

        when(inventoryService.checkInventory(any())).thenReturn(true);
        when(paymentService.processPayment(any(), anyDouble())).thenReturn(true);
        when(repository.saveOrder(any(), anyDouble())).thenReturn(true);
        when(emailService.sendEmail(anyString(), anyString())).thenReturn(false);
        assertFalse(processor.process(order));

        when(inventoryService.checkInventory(any())).thenReturn(false);
        when(paymentService.processPayment(any(), anyDouble())).thenReturn(false);
        when(repository.saveOrder(any(), anyDouble())).thenReturn(false);
        when(emailService.sendEmail(anyString(), anyString())).thenReturn(false);
        assertFalse(processor.process(order));
    }
}

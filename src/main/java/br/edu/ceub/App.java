package br.edu.ceub;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // Criação de um pedido com alguns itens.
        List<OrderItem> items = List.of(
                new OrderItem("Produto A", 60.0, 1),
                new OrderItem("Produto B", 50.0, 2),
                new OrderItem("Produto C", 30.0, 3)
        );
        Order order = new Order("ORD123", items);

        // Processamento do pedido.
        OrderProcessor processor = new OrderProcessor();
        boolean success = processor.process(order);

        if (success) {
            System.out.println("Pedido processado com sucesso!");
        } else {
            System.out.println("Falha ao processar o pedido.");
        }
    }

    public static int somar (int a, int b) {
        return a + b;
    }
}

package br.edu.ceub;
// Serviço responsável por processar o pagamento do pedido.
// Retorna um boolean indicando se o pagamento foi realizado com sucesso.

public class PaymentService {
    public boolean processPayment(Order order, double amount) {
        // Calcula o total esperado do pedido somando o preço de cada item multiplicado pela sua quantidade
        double expectedTotal = 0;
        for (OrderItem item : order.getItems()) {
            expectedTotal += item.getPrice() * item.getQuantity();
        }

        // Lógica de negócio: se o valor pago for inferior ao total esperado, o pagamento falha
        if (amount < expectedTotal) {
            System.out.println("Pagamento insuficiente para o pedido " + order.getOrderId() +
                    ". Total esperado: " + expectedTotal + ", recebido: " + amount);
            return false;
        }

        // Se o valor pago é igual ou superior ao esperado, o pagamento é processado com sucesso
        System.out.println("Pagamento de " + amount + " processado para o pedido " + order.getOrderId() +
                ". Total esperado: " + expectedTotal);
        return true;
    }
}

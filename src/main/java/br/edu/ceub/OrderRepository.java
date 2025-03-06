package br.edu.ceub;

import java.io.FileWriter;
import java.io.IOException;

// Repositório que salva o pedido persistindo informações em um arquivo.
// Retorna true se a operação de escrita foi bem-sucedida.
class OrderRepository {
    public boolean saveOrder(Order order, double finalTotal) {
        return false;
        try {
            FileWriter writer = new FileWriter("orders.txt", true);
            writer.write("Pedido " + order.getOrderId() + " salvo com total: " + finalTotal + "\n");
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
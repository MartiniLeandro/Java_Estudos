package ExercisePagamento.application;


import java.util.List;

import ExercisePagamento.entities.Boleto;
import ExercisePagamento.entities.CartaoDeCredito;
import ExercisePagamento.entities.Pix;
import ExercisePagamento.interfaces.MetodoPagamento;

public class Program {
    public static void main(String[] args) {
        CartaoDeCredito cartaoDeCredito = new CartaoDeCredito(800.0);
        Boleto boleto = new Boleto(800.0);
        Pix pix = new Pix(800.0);
        List<MetodoPagamento> metodosPagamento = List.of(cartaoDeCredito,boleto,pix);

        

        System.out.println("==== PAGAMENTOS ====");
        for (MetodoPagamento metodoPagamento : metodosPagamento) {
            metodoPagamento.pagamento(1000);
        }
    }
}


package POO.Herança;

public class Program {
    public static void main(String[] args) {
         Conta conta = new Conta(1003,"Bob", 0.0);
         ContaBancaria contaBancaria = new ContaBancaria(1002, "Maria", 0.0, 500.0);

         // UPCASTING

         Conta acc1 = contaBancaria;
         Conta acc2 = new ContaBancaria(1003, "Bob", 0.0, 200.0);
         Conta acc3 = new ContaPoupanca(1004, "Anna", 0.0, 0.01);

         // DOWNCASTING

         ContaBancaria acc4 = (ContaBancaria)acc2;
         // ContaBancaria acc5 = (ContaBancaria)acc3; DA ERRO;
         if(acc3 instanceof ContaBancaria){
            ContaBancaria acc5 = (ContaBancaria)acc3;
            acc5.emprestimo(200.0);
            System.out.println("Empréstimo");
         }
         if(acc3 instanceof ContaPoupanca){
            ContaPoupanca acc5 = (ContaPoupanca)acc3;
            acc5.SaldoAtualizado();
            System.out.println("SALDO ATUALIZADO");
         }

        
    }
}

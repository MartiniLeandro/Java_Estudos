package POO.classes;

public class SistemaEnergia {
    private int numeroConta;
    private String titularConta;
    private double consumoEnergia;

    public SistemaEnergia(int numeroConta, String titularConta, double consumoEnergia){
        this.numeroConta = numeroConta;
        this.titularConta = titularConta;
        this.consumoEnergia = consumoEnergia;
    }
    public SistemaEnergia(int numeroConta, String titularConta){
        this.numeroConta = numeroConta;
        this.titularConta = titularConta;
        this.consumoEnergia = 0;
    }

    public int getNumeroConta(){
        return this.numeroConta;
    }
    public String getTitularConta(){
        return this.titularConta;
    }
    public void setTitularConta(String titularConta){
         this.titularConta = titularConta;
    }
    public double getConsumoEnergia(){
        return this.consumoEnergia;
    }

    public void adicionarConsumo(int consumo){
        this.consumoEnergia +=consumo;
    }
    
    public void calcularValorTarifa(double tarifa){
        double valorConsumo = this.consumoEnergia * tarifa;
        System.out.println("Total da conta: " + valorConsumo);
    }
}

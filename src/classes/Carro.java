package src.classes;

public class Carro {
    public String marca;
    public String modelo;
    public int ano;
    public double velocidadeAtual;

    public double acelerar(double incremento){
        return velocidadeAtual += incremento;
    }
    public double frear(double frear) {
        if(velocidadeAtual - frear  >= 0){
            return velocidadeAtual -= frear;
        }
        return velocidadeAtual = 0;
    }
    public void exibirInformacoes(){
        System.out.println("Informações finais do carro: ");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("velocidade atual: " + velocidadeAtual);
    }
}

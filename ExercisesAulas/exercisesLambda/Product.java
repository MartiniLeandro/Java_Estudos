package ExercisesAulas.exercisesLambda;

public class Product{
    private String nome;
    private Double valor;

    public Product(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public static void staticConsumer(Product p){
        p.setValor(p.getValor() * 1.1);
    }

    public void NoStaticConsumer(){
        valor = valor * 1.1;
    }

    @Override
	public String toString() {
		return nome + ", " + String.format("%.2f", valor);
	}

    
}

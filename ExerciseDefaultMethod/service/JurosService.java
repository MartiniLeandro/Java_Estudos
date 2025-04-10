package ExerciseDefaultMethod.service;

public interface JurosService {
    
    double getTaxaJuros();
    default double pagamento(double valor, int meses){
        return valor * Math.pow((1 + getTaxaJuros() / 100),meses);
    }

}

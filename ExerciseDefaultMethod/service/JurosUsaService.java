package ExerciseDefaultMethod.service;

public class JurosUsaService implements JurosService{
    private double taxaJuros;

    public JurosUsaService(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    @Override
    public double getTaxaJuros() {
        return taxaJuros;
    }
    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }
    

}

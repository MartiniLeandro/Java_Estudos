package ExerciseDefaultMethod.service;

public class JurosBrasilService implements JurosService{
    private double taxaJuros;

    public JurosBrasilService(double taxaJuros) {
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

package ExerciseFormatosInterface.interfaces;

import ExerciseFormatosInterface.entities.Cores;

public  abstract class FormatoAbstract implements Formato{
    private Cores cor;
    
    public FormatoAbstract(Cores cor) {
        this.cor = cor;
    }

    public Cores getCor() {
        return cor;
    }

    public void setCor(Cores cor) {
        this.cor = cor;
    }

    
    
}

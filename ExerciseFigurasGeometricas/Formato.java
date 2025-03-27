package ExerciseFigurasGeometricas;

public abstract class Formato {
    private Cores cor;

    public Formato(){};

    public Formato(Cores cor){this.cor = cor;}


    public Cores getCor(){
        return this.cor;
    }
    public void SetCor(Cores cor){
        this.cor = cor;
    }

    public abstract Double area(){
        
    }
}

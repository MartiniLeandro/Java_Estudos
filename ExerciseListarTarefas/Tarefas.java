package ExerciseListarTarefas;

public class Tarefas {
    private String titulo;
    private String descricao;
    private Integer id;

    public Tarefas(){};

    public Tarefas(String titulo, String descricao, Integer id){
        this.titulo = titulo;
        this.descricao = descricao;
        this.id = id;
    }

    public String getTitulo(){
        return this.titulo;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public Integer getId(){
        return this.id;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setDescricao(String desc){
        this.descricao = desc;
    }
    public void setId(Integer id){
        this.id = id;
    }
}

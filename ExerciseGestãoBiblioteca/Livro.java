package ExerciseGestãoBiblioteca;

public class Livro {
    private String titulo;
    private String autor;
    private Integer anoPublicado;
    private StatusLivro status;

    public Livro(){};
    public Livro(String titulo, String autor, Integer anoPublicado, StatusLivro status){
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicado = anoPublicado;
        this.status = status;
    }

    public String getTitulo(){
        return this.titulo;
    }
    public String getAutor(){
        return this.autor;
    }
    public Integer getAnoPublicado(){
        return this.anoPublicado;
    }
    public StatusLivro getStatus(){
        return this.status;
    }

    public void setStatus(StatusLivro status){
        this.status = status;
    }

    @Override 
    public String toString(){
        return "Titulo: " + getTitulo() + ", Autor: " + getAutor() + ", Ano Publicado: " + getAnoPublicado() + ", Status do Livro: " + getStatus() + " || ";
    }
}

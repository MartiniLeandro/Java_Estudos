package ExercisePost;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private LocalDateTime moment;
    private String title;
    private String content;
    private Integer likes;
    private List<Comment> comments = new ArrayList<>();

    public Post(){};

    public Post(LocalDateTime moment, String title, String content, Integer likes){
        this.moment = moment;
        this.title = title;
        this.content = content;
        this.likes = likes;
    };

    public LocalDateTime getMoment(){
        return this.moment;
    }
    public String getTitle(){
        return this.title;
    }
    public String getContent(){
        return this.content;
    }
    public Integer getLikes(){
        return this.likes;
    }
    public List<Comment> getComments(){
        return this.comments;
    }

    public void setMoment(LocalDateTime moment){
        this.moment = moment;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setContent(String content){
        this.content = content;
    }
    public void setLikes(Integer likes){
        this.likes = likes;
    }

    public void addComent(Comment comentario){
        comments.add(comentario);
    }


    public String toString() {
    return "Título: " + title + "\n" +
           "Conteúdo: " + content + "\n" +
           "Likes: " + likes + "\n" +
           "Data: " + moment + "\n" +
           "Comentários: " + comments;
}

}

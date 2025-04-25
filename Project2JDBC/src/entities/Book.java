package entities;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable{
    private Integer id;
    private String title;
    private Date publishDate;
    private Integer authorId;

    public Book(){}

    public Book(Integer id, String title, Date publishDate, Integer authorId) {
        this.id = id;
        this.title = title;
        this.publishDate = publishDate;
        this.authorId = authorId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getAuthor() {
        return authorId;
    }

    public void setAuthor(Integer authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", publishDate=" + publishDate + ", authorId=" + authorId + "]";
    }

    
    

    

}

package blog.article;

import blog.auteur.Author;
import blog.comment.Comment;
import blog.core.BaseEntity;
import blog.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Article extends BaseEntity{

    @NotNull
    @Size(min = 1, max = 140)
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToOne
    private User utilisateur;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<Comment> comments;

    private LocalTime dateOfCreation;

    @NotNull
    @Size(min = 1, max = 280)
    private String content;

    protected Article(){
        super();
        dateOfCreation = LocalTime.now();
        comments = new ArrayList<>();
    }

    public Article(String title , String content){
        this();
        this.content = content;
        this.title = title;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        comment.setArticle(this);
        comments.add(comment);
    }

    public User getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(User utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public LocalTime getDateOfCreation() {
        return dateOfCreation;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

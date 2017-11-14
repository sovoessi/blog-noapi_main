package blog.comment;


import blog.article.Article;
import blog.auteur.Author;
import blog.core.BaseEntity;
import blog.user.User;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalTime;

@Entity
public class Comment extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @OneToOne
    private Author author;

    @OneToOne
    private User utilisateur;

    private LocalTime dateOfCreation;

    @NotNull
    @Size(min = 1, max = 280)
    private String content;

    protected Comment() {
        super();
        dateOfCreation = LocalTime.now();
    }

    public Comment(String content) {
        this();
        this.content = content;
    }

    public User getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(User utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

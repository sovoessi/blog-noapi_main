package blog.auteur;


import blog.article.Article;
import blog.core.BaseEntity;
import blog.user.User;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Author extends BaseEntity{

    private String pseudo;

    @OneToOne
    private User utilisateur;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Article> articles;

    protected Author(){
        super();
        articles = new ArrayList<>();
    }

    public Author(String pseudo) {
        this();
        this.pseudo = pseudo;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public User getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(User utilisateur) {
        this.utilisateur = utilisateur;
    }


    public void addArticle(Article article) {
        article.setAuthor(this);
        articles.add(article);
    }
}

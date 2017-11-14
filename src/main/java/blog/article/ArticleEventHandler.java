package blog.article;

import blog.user.User;
import blog.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Article.class)
public class ArticleEventHandler {

    private final UserRepository users;

    @Autowired
    public ArticleEventHandler(UserRepository users){
        this.users = users;
    }

    @HandleBeforeCreate
    public void addArticleBasedOnLoggedInUser(Article article){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findByEmail(email);
        article.setUtilisateur(user);
    }

}

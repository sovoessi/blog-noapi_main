package blog.auteur;

import blog.user.User;
import blog.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Author.class)
public class AuthorEventHandler {

    private final UserRepository users;

    @Autowired
    public AuthorEventHandler(UserRepository users){
        this.users = users;
    }

    @HandleBeforeCreate
    public void addAuthorBasedOnLoggedInUser(Author author){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findByEmail(email);
        author.setUtilisateur(user);
    }

}

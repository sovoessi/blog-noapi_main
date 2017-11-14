package blog.comment;

import blog.user.User;
import blog.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Comment.class)
public class CommentEventHandler {

    private final UserRepository users;

    @Autowired
    public CommentEventHandler(UserRepository users){
        this.users = users;
    }

    @HandleBeforeCreate
    public void addCommentBasedOnLoggedInUser(Comment comment){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findByEmail(email);
        comment.setUtilisateur(user);
    }

}

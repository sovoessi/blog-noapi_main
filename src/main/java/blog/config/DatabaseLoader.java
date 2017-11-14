package blog.config;

import blog.article.Article;
import blog.article.ArticleRepository;
import blog.auteur.Author;
import blog.comment.Comment;
import blog.comment.CommentRepository;
import blog.user.User;
import blog.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseLoader implements ApplicationRunner {

    private final ArticleRepository articles;
    private final CommentRepository comments;
    private final UserRepository users;

    @Autowired
    public DatabaseLoader(ArticleRepository articles, CommentRepository comments, UserRepository users) {
        this.articles = articles;
        this.comments = comments;
        this.users = users;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {


        List<User> visitors = Arrays.asList(
                new User("jacobproffer@email.com", "Proffer", new String[]{"ROLE_USER"}),
                new User("mlnorman@email.com", "password", new String[]{"ROLE_USER"}),
                new User("k_freemansmith@email.com", "password", new String[]{"ROLE_USER"})
        );
        users.save(visitors);

        List<Article> edition = Arrays.asList(
                new Article(
                        "Small, raw pudding is best soaked with minced mint sauce.",
                        "Developpement sous php"
                ),
                new Article(
                        "species Be meaningless.",
                        "autre language C"
                ),
                new Article(
                        "Nunquam imperium nuptia.The individual experiences.",
                        "Python autre language C#"
                ),
                new Article(
                        "Superbus, raptus amicitias nunquam acquirere de barbatus," +
                                " mirabilis sensorem.species Be meaningless.",
                        "Java entre autre  language "
                ),
                new Article(
                        "Talis torquiss ducunt ad candidatus. species Be meaningless.",
                        "Java ou C"
                ),
                new Article(
                        "species Be meaningless.Power drain, beauty, and moon.",
                        "plus important Javascript ou JS"
                ),
                new Article(
                        "Go wihtout attitude, and we won’t deceive a processor.species Be meaningless.",
                        "With chicories drink white wine. "
                ),
                new Article(
                        "If you balance or empower with a playful extend, pain shapes you.species Be meaningless.",
                        "C php Java JS Python C#"
                )
        );
        articles.save(edition);


        List<Comment> commentaires = Arrays.asList(
                new Comment(
                        "With herrings drink hollandaise sauce."
                ),
                new Comment(
                        "Evil deaths avoids most peace. Teres ionicis tormento sensim promissios guttus est."
                ),
                new Comment("The seeker gains. Cacula, vita, et calceus."
                ),
                new Comment(
                        "With herrings drink hollandaise sauce."
                ),
                new Comment(
                        "Evil deaths avoids most peace. Teres ionicis tormento sensim promissios guttus est."
                )

        );
        comments.save(commentaires);

        users.save(new User("jack@email.com", "password", new String[] {"ROLE_USER", "ROLE_MANAGER", "ROLE_ADMIN"}));
    }

}

package blog.comment;


import blog.article.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @RequestMapping("/comments")
    public @ResponseBody List<Comment> listComments(){

        return commentRepository.findAll();
    }

    @RequestMapping("/ajout/commentaire")
    public @ResponseBody String ajoutCommentaire(
                                             @RequestParam String commentaire){
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Comment com = new Comment(commentaire);
        commentRepository.save(com);
        return "Commentaire ajouté";
    }




}

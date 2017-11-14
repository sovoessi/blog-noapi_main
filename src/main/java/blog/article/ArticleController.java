package blog.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/bloghappy")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping("/articles")
    public @ResponseBody List<Article> listArticles(){

        return articleRepository.findAll();
    }

    @RequestMapping("/article")
    public @ResponseBody List<Article> article(@RequestParam(value = "title") String title){

        return articleRepository.findByTitle(title);
    }

    @RequestMapping("/ajout/article")
    public @ResponseBody String ajoutArticle(@RequestParam String title,
                                             @RequestParam String content){
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Article art = new Article(title, content);

        articleRepository.save(art);
        return "Article ajouté";
    }



}

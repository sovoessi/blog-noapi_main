package blog.article;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Long> {

    List<Article> findAll();

    @RestResource(rel ="title-contains", path ="containsTitle")
    List<Article> findByTitle(@Param("title") String titre);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or @articleRepository.findOne(#id)?.auteur?.utilisateur?.email == authentication.name")
    void delete(@Param("id") Long id);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or #article.auteur?.utilisateur?.email == authentication.name")
    void delete(@Param("article") Article entity);
}

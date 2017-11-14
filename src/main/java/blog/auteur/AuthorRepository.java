package blog.auteur;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    List<Author> findByPseudo(String pseudo);
    List<Author> findAll();
}

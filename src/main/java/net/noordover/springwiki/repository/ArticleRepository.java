package net.noordover.springwiki.repository;

import net.noordover.springwiki.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
        public Article findByTopic(String topic);
}

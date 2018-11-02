package net.noordover.springwiki;

import java.util.Date;
import java.util.Optional;
import net.noordover.springwiki.model.Article;
import net.noordover.springwiki.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringwikiApplication {

        @Autowired
        private ArticleRepository articleRepository;

        public static void main(String[] args) {
                SpringApplication.run(SpringwikiApplication.class, args);
        }

        @EventListener
        public void onApplicationEvent(ContextRefreshedEvent event) {
                Article homePage = articleRepository.findByTopic("HomePage");
                if (homePage == null) {
                        Article article = new Article();
                        article.setTopic("HomePage");
                        article.setPublished(new Date());
                        article.setContent("Edit this content please!");
                        articleRepository.save(article);
                }
        }
}

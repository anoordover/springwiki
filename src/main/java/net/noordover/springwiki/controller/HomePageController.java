package net.noordover.springwiki.controller;

import javax.transaction.Transactional;
import net.noordover.springwiki.model.Article;
import net.noordover.springwiki.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {
        @Autowired
        private ArticleRepository articleRepository;

        @GetMapping(path="/")
        public ModelAndView getHomePage() {
                ModelAndView result = new ModelAndView("details");
                result.addObject("article", articleRepository.findByTopic("HomePage"));
                return result;
        }

        @GetMapping(path = "/articles/add")
        public String createProduct(Model model) {
                model.addAttribute("article", new Article());
                return "edit";
        }

        @GetMapping(path = "/articles/{topic}")
        public String createProduct(Model model, @PathVariable String topic) {
                model.addAttribute("article", articleRepository.findByTopic(topic));
                return "details";
        }

        @GetMapping(path = "/articles/edit/{topic}")
        public String editArticle(Model model, @PathVariable String topic) {
                model.addAttribute("article", articleRepository.findByTopic(topic));
                return "edit";
        }

        @PostMapping(path = "articles")
        @Transactional
        public String saveProduct(Article article) {
                articleRepository.save(article);
                if ("HomePage".equals(article.getTopic()))
                        return "redirect:/";
                return "redirect:/articles/" + article.getTopic();
        }
}

package net.noordover.springwiki.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(indexes = {@Index(name="TopicIndex", columnList = "topic")})
public class Article {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String topic;
        @Column(updatable = false)
        private Date published = new Date();
        private String content;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getTopic() {
                return topic;
        }

        public void setTopic(String topic) {
                this.topic = topic;
        }

        public Date getPublished() {
                return published;
        }

        public void setPublished(Date published) {
                this.published = published;
        }

        public String getContent() {
                return content;
        }

        public void setContent(String content) {
                this.content = content;
        }
}

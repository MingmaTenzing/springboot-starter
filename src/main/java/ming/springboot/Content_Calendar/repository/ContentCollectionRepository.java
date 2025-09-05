package ming.springboot.Content_Calendar.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import ming.springboot.Content_Calendar.model.Content;
import ming.springboot.Content_Calendar.model.Status;
import ming.springboot.Content_Calendar.model.Type;



@Repository
public class ContentCollectionRepository {
    private final List<Content> content = new ArrayList<>();

    public ContentCollectionRepository() {

    }

    public List<Content> findAll() {
        return content;
    }

    public Optional<Content> findbyId(Integer id) {
        return content.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public List<Content> addContent(Content data) {

        content.add(data);
        return content;


    }

    @PostConstruct
    public void addData() {
        Content c = new Content(1,
                "Spring Boot Basics",
                "Introduction to building REST APIs with Spring Boot",
                Status.COMPLETED,
                Type.ARTICLE,
                LocalDateTime.now().minusDays(10),
                LocalDateTime.now().minusDays(5),
                "https://example.com/spring-boot-basics");

        Content c2 = new Content(2,
                "Docker for Java Devs",
                "Learn how to containerize Spring Boot applications",
                Status.PUBLISHED,
                Type.VIDEO,
                LocalDateTime.now().minusDays(7),
                LocalDateTime.now().minusDays(3),
                "https://example.com/docker-java");

                content.add(c);
                content.add(c2);
    }

    
    
}



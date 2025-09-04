package ming.springboot.Content_Calendar.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ming.springboot.Content_Calendar.model.Content;
import ming.springboot.Content_Calendar.repository.ContentCollectionRepository;

@RestController


@RequestMapping ("/api/content")

public class ContentController {
  


    private final ContentCollectionRepository repository; 
    
    public ContentController(ContentCollectionRepository repository) {

        this.repository = repository;
    }
    
    @GetMapping("getall")
    public List<Content> findAll() {
        return repository.findAll();
    }
}
 
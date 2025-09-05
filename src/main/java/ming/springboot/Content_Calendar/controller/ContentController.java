package ming.springboot.Content_Calendar.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ming.springboot.Content_Calendar.model.Content;
import ming.springboot.Content_Calendar.repository.ContentCollectionRepository;

@RestController


@RequestMapping ("/api/content")

public class ContentController {
  


    private final ContentCollectionRepository repository; 
    
    public ContentController(ContentCollectionRepository injectrepository) {

        this.repository = injectrepository;
    }
    
    @GetMapping("")
    public List<Content> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findOne(@PathVariable Integer id) {
        return repository.findbyId(id)
                .orElseThrow((() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "not found")));
    }
    

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping ("/add") 

    public List<Content> addContent(@RequestBody Content provided_obj) {
        return repository.addContent(provided_obj);
    }
}
 
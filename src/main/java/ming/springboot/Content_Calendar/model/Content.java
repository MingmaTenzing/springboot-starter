package ming.springboot.Content_Calendar.model;

import java.time.LocalDateTime;

public record Content(
    Integer id,
    String title,
    String desc, 
    Status status,
    Type contenType, 
    LocalDateTime dateCreated,
    LocalDateTime dateUpdated, 
    String url
                                    

) {

    
 
}

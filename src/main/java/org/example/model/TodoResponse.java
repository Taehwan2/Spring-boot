package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoResponse {
    private Long id;
    private String title;
    private Long order;
    private Boolean completed;
    private String url;

    public TodoResponse(Todomodel todomodel){
        this.id = todomodel.getId();
        this.title = todomodel.getTitle();
        this.order = todomodel.getOrder();
        this.completed = todomodel.getCompleted();

        this.url = "http://localhost:8080/"+this.id;
    }

}

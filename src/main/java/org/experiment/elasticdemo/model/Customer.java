package org.experiment.elasticdemo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "my-application",type = "customer")
public class Customer {

    private Long id;
    private String firstName;
    private String lastName;
    private int age;
}

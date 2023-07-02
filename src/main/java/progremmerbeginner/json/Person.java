package progremmerbeginner.json;

import lombok.Data;

import java.util.List;
@Data
public class Person {

    private String id;

    private String name;

    private List<String> hobbies;

    private Address address;


}

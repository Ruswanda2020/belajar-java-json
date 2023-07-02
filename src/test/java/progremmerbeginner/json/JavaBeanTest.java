package progremmerbeginner.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JavaBeanTest {

    @Test
    void createJsonFromObject() throws JsonProcessingException {

        Person person = new Person();
        person.setId("1");
        person.setName("wanda");
        person.setHobbies(List.of("coding","podcast","sport"));

        Address address = new Address();
        address.setStreet("golden prak");
        address.setCity("tangsel");
        address.setCountry("indonesia");
        person.setAddress(address);


        ObjectMapper objectMapper = new ObjectMapper();
        String json =objectMapper.writeValueAsString(person);

        System.out.println(json);
    }

    @Test
    void readObjectFromJson() throws JsonProcessingException {
        String json= """
                                
                                
                {"id":"1",
                  "name":"wanda",
                                
                  "hobbies":["coding","podcast","sport"],
                                
                  "address":{"street":"golden prak","city":"tangsel",
                    "country":"indonesia"}
                }
                                
                                
                """;


        ObjectMapper objectMapper = new ObjectMapper();

        Person person = objectMapper.readValue(json,Person.class);

        Assertions.assertEquals("wanda",person.getName());
    }


}

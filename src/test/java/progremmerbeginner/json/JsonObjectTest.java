package progremmerbeginner.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class JsonObjectTest {

    @Test
    void createJsonObject() throws JsonProcessingException {

        Map<String ,Object> person = Map.of(
                "firstName","wanda",
                "lastName","nugraha",
                "age",23,
                "married",true,
                "address",Map.of(
                        "street","jl.cintumput",
                        "city","jakarta",
                        "country","indonesia"
                )
        );


        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);

        System.out.println(json);
    }

    @Test
    void readJson() throws JsonProcessingException {
        String json = """
                {
                  "address":{"city":"jakarta",
                    "country":"indonesia",
                    "street":"jl.cintumput"},
                                
                  "firstName":"wanda",
                  "lastName":"nugraha",
                  "married":true,
                  "age":23
                }
                """;


        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> person = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
        });

        Assertions.assertEquals("wanda",person.get("firstName"));
        Assertions.assertEquals("nugraha",person.get("lastName"));
    }
}

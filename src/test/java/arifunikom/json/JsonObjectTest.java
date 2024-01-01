package arifunikom.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class JsonObjectTest {

    @Test
    void createJson() throws JsonProcessingException {
        Map<String, Object> person = Map.of(
                "firstName", "Arif",
                "lastName", "Ramadhan",
                "age", 19,
                "married", false,
                "address", Map.of(
                        "street", "jalan Dipatiukur",
                        "city", "Bandung",
                        "country", "Indonesia"
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
                   "age":19,
                   "married":false,
                   "lastName":"Ramadhan",
                   "firstName":"Arif",
                   "address":{
                      "street":"jalan Dipatiukur",
                      "country":"Indonesia",
                      "city":"Bandung"
                   }
                }
                """;

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> person = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
        });

        Assertions.assertEquals("Arif", person.get("firstName"));
        Assertions.assertEquals("Ramadhan", person.get("lastName"));

    }

}

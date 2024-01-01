package arifunikom.json;

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
        person.setName("Arif Nur Ramadhan");
        person.setHobbies(List.of("Futsal","Martial"));

        Address address = new Address();
        address.setStreet("Jalan dipatiukur");
        address.setCity("Bandung");
        address.setCountry("Indonesia");
        person.setAddress(address);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);

        System.out.println(json);

    }

    @Test
    void readObjectFromJson() throws JsonProcessingException {
        String json = """
                {"id":"1","name":"Arif","hobbies":["Futsal","Martial"],"address":{"street":"Jalan dipatiukur","city":"Bandung","country":"Indonesia"}}
                """;

        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(json, Person.class);

        Assertions.assertEquals("Arif", person.getName());
        Assertions.assertEquals("Bandung", person.getAddress().getCity());
        Assertions.assertEquals("Martial", person.getHobbies().get(1));

    }

}

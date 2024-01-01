package arifunikom.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AnnotationTest {

    @Test
    void annotation() throws JsonProcessingException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .setDateFormat(dateFormat);

        Person person = new Person();
        person.setId("1");
        person.setName("Arif");
        person.setFullName("Arif Nur Ramadhan");
        person.setPassword("rahasia");
        person.setCreateAt(new Date());
        person.setUpdateAt(new Date());

        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);
    }

}

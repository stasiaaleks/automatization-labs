package example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;
import java.util.List;

public class StringUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> String stringifyToJson(List<T> objList) throws JsonProcessingException {
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objList);
    }
}

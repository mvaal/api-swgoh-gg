package gg.swgoh.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import gg.swgoh.api.actions.Abilities;
import gg.swgoh.api.actions.Characters;
import lombok.SneakyThrows;
import org.apache.commons.text.StringSubstitutor;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import static org.apache.commons.text.StringSubstitutor.*;

public class Client {
    private OkHttpClient client = new OkHttpClient();
    private final String url;

    public static Client get() {
        return new Client();
    }

    public Client() {
        this("https://swgoh.gg/api/");
    }

    public Client(String url) {
        this.url = url;
    }

    public <T> T action(String template, Class<T> clazz) {
        return action(template, Collections.emptyMap(), clazz);
    }

    @SneakyThrows(IOException.class)
    public <T> T action(String template, Map<String, String> parameters, Class<T> clazz) {
        Request request = new Request.Builder()
                .url(substitute(template, parameters))
                .get()
                .build();

        ObjectMapper mapper = new ObjectMapper();
        Response response = client.newCall(request).execute();
        return mapper.readValue(response.body().byteStream(), clazz);
    }

    private String substitute(String template, Map<String, String> parameters) {
        String templateString = String.format("%s%s", url, template);
        StringSubstitutor sub = new StringSubstitutor(parameters, "{", "}", DEFAULT_ESCAPE);
        return sub.replace(templateString);
    }

    public Abilities abilities() {
        return new Abilities(this);
    }

    public Characters characters() {
        return new Characters(this);
    }
}

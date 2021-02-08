package springboot.service;

import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import springboot.dtos.Question;
import springboot.dtos.Questions;

import java.util.List;

@Service
public class SearchService {

    @Value("${app.searchUrl}")
    private String searchUrl;

    private RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory(HttpClientBuilder.create().build()));

    @Retryable(maxAttempts = 3, value = Exception.class, backoff = @Backoff(delay = 500, multiplier = 2))
    public List<Question> getQuestions(@NonNull String search) {

        ResponseEntity<Questions> response = restTemplate.getForEntity(searchUrl, Questions.class, ImmutableMap.of("search", search));
        return response.getBody().getItems();
    }
}

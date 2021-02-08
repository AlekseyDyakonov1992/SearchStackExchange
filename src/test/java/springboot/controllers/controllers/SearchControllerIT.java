package springboot.controllers.controllers;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springboot.dtos.Question;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SearchControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getListOfQuestion() throws Exception {
        ResponseEntity<List<Question>> responseEntity = restTemplate.exchange("/search", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Question>>() {
                });

        List<Question> actualList = responseEntity.getBody();
        //validate
        assertThat(actualList.size(), is(30));
        List<String> actualTitleList = actualList.stream().map(question -> question.getTitle()).collect(collectingAndThen(Collectors.toList(), ImmutableList::copyOf));
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

}
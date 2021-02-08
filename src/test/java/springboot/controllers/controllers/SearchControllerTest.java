package springboot.controllers.controllers;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import springboot.controllers.SearchController;
import springboot.dtos.Question;
import springboot.service.SearchService;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SearchControllerTest {

    @Mock
    private SearchService searchService;

    @InjectMocks
    SearchController searchController;

    @Test
    public void getListOfQuestion() throws Exception {
        //prepare
        when(searchService.getQuestions("")).thenReturn(ImmutableList.of());
        //testing
        List<Question> listOfQuestion = searchController.getListOfQuestion("");
        //validate
        verify(searchService).getQuestions("");
    }

}
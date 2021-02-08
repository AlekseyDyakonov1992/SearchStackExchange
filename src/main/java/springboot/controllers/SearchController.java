package springboot.controllers;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.dtos.Question;
import springboot.service.SearchService;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Question> getListOfQuestion(@RequestParam(value = "title", defaultValue = "") @NonNull String search) {
        return searchService.getQuestions(search);
    }
}

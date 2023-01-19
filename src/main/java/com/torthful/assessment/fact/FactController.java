package com.torthful.assessment.fact;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
public class FactController {

    private final ApiCallService apiCallService;

    public FactController(ApiCallService apiCallService) {
        this.apiCallService = apiCallService;
    }

    @GetMapping(path = "/fun-facts/{cnt}")
    public ResponseEntity<List<Fact>> funFacts(@PathVariable(required = true) @Min(1) @Max(30) int cnt) {
        List<Fact> response = apiCallService.facts(cnt);
        return new ResponseEntity(response, HttpStatus.OK);
    }


}


package br.com.pedrocarmona.testbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedrocarmona.testbackend.model.QueryResponse;
import br.com.pedrocarmona.testbackend.service.QueryService;

@RestController
@RequestMapping("/")
public class QueryController {
    
    @Autowired
    QueryService queryService;

    @GetMapping
    private ResponseEntity<QueryResponse> getQuestions(@RequestParam String searchParam){
        try{
            QueryResponse queryResponse = queryService.search(searchParam);
            return new ResponseEntity<>(queryResponse, HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

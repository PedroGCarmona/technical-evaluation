package br.com.pedrocarmona.testbackend.service;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.pedrocarmona.testbackend.client.StackOverflowClient;
import br.com.pedrocarmona.testbackend.model.QueryResponse;
import br.com.pedrocarmona.testbackend.utils.GzipDeserializer;

@Service
public class QueryService {
    
    @Autowired
    StackOverflowClient client;
    
    @Autowired
    ObjectMapper objectMapper;

    @Value(value = "${api.siteParam}")
    String siteParam;

    public QueryResponse search(String searchParam) throws IOException{
        String json = GzipDeserializer.gzipToJson(client.getQuestions(searchParam, siteParam));
        QueryResponse queryResponse = objectMapper.readValue(json, QueryResponse.class);
        return queryResponse;
    }

}

package br.com.pedrocarmona.testbackend.service;

import java.io.IOException;
import java.net.ConnectException;
import java.util.zip.ZipException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.pedrocarmona.testbackend.client.StackOverflowClient;
import br.com.pedrocarmona.testbackend.model.QueryResponse;
import br.com.pedrocarmona.testbackend.utils.GzipDeserializer;
import feign.FeignException.FeignClientException;

@Service
public class QueryService {
    
    @Autowired
    StackOverflowClient client;
    
    @Autowired
    ObjectMapper objectMapper;

    @Value(value = "${api-param.siteParam}")
    String siteParam;

    public QueryResponse search(String searchParam) throws IOException{
        QueryResponse queryResponse = null;

        try{
            byte[] clientResponse = client.getQuestions(searchParam, siteParam);
            String json = GzipDeserializer.gzipToJson(clientResponse);
            queryResponse = objectMapper.readValue(json, QueryResponse.class);
        }
        catch(FeignClientException e){
            e.printStackTrace();
            throw new IOException("Failure to communicate with the client. Cause: " + e.getMessage());
        }
        catch(ZipException e){
            e.printStackTrace();
            throw e;
        }
        catch(JsonProcessingException e){
            e.printStackTrace();
            throw e;
        }

        return queryResponse;
    }

}

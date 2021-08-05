package br.com.pedrocarmona.testbackend.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.zip.ZipException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Value;

import br.com.pedrocarmona.testbackend.client.StackOverflowClient;
import br.com.pedrocarmona.testbackend.utils.GzipDeserializer;
import feign.FeignException.FeignClientException;

@RunWith(MockitoJUnitRunner.class)
public class QueryServiceTest {
    
    @InjectMocks
    QueryService queryService;

    @Mock
    StackOverflowClient stackOverflowClient;

    @Mock
    ObjectMapper objectMapper;

    @Value(value = "${api-param.siteParam}")
    String siteParam;

    @Test
    public void shouldThrowIOExceptionWhenFeignClientExceptionOccurs() throws IOException{
        FeignClientException exception = mock(FeignClientException.class);
        String searchParam = "teste";
        
        assertThrows(IOException.class, () -> {
            when(stackOverflowClient.getQuestions(searchParam, siteParam))
            .thenThrow(exception);

            queryService.search(searchParam);
        });
    }

    @Test
    public void shouldThrowIOExceptionWhenGzipDeserializerFails() throws IOException{
        ZipException exception = mock(ZipException.class);
        byte[] byteParam = {};
        String searchParam = "teste";
        
        assertThrows(IOException.class, () -> {
            when(GzipDeserializer.gzipToJson(byteParam))
            .thenThrow(exception);

            queryService.search(searchParam);
        });
    }
    
}

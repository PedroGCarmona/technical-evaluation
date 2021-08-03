package br.com.pedrocarmona.testbackend.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "StackOverflowClient", url = "${api-param.url}")
public interface StackOverflowClient {
    
    @GetMapping(value="")
    public byte[] getQuestions(@RequestParam String q, @RequestParam String site);

}

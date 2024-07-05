package com.example.articleproject.services;

import com.example.articleproject.dto.StockDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

public class StockClientImp {

    RestTemplate restTemplate = new RestTemplate();

   // @Value("param.baseurl")
    private String baseURL="http://localhost:8086";


    public StockDTO getById(String id){

        HttpEntity<String> request = new HttpEntity<String>(getHeaders());
        ResponseEntity response = restTemplate.exchange(baseURL+"/stock/getbyid/"+id,HttpMethod.GET,request,StockDTO.class);
        ObjectMapper mapper = new ObjectMapper();

        StockDTO stockDTO =mapper.convertValue(response.getBody(),new com.fasterxml.jackson.core.type.TypeReference<StockDTO>(){});
        return stockDTO;
    }

    private String getHeaders() {
        return null;
    }

}

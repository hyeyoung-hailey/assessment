package com.torthful.assessment.fact;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@Service
public class ApiCallService {
    @Value("${api.key}")
    private String apiKey;

    @Value("${api.url}")
    private String baseUrl;

    public List<Fact> facts(int cnt) {

        URI uri = UriComponentsBuilder
                .fromUriString(baseUrl)
                .queryParam("limit", cnt)
                .encode()
                .build()
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Api-Key", apiKey);

        HttpEntity<String> entity = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Fact>> response = restTemplate.exchange(uri,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Fact>>() {
                });

        return response.getBody();
    }
}

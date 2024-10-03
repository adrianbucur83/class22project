package com.siit.class22project.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExchangeRateService {

    public String getExchangeRate() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "https://www.cursbnr.ro/insert/cursvalutar.php?w=200&b=f7f7f7&bl=dcdcdc&ttc=0a6eab&tc=000000&diff=1&ron=1&cb=1&pics=1";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);

        String body = response.getBody();
        int startIndex = body.indexOf("1 EUR =");
        int endIndex = startIndex + 14;

        return body.substring(startIndex, endIndex);
    }


}

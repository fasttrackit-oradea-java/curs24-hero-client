package ro.fasttrackit.curs24;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ro.fasttrackit.curs24.domain.Hero;

import java.util.List;

public class HeroService {
    private final String serviceUrl;
    private RestTemplate rest = new RestTemplate();

    public HeroService(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public List<Hero> getAll() {
        ResponseEntity<List<Hero>> response = rest.exchange(serviceUrl + "/heroes",
                HttpMethod.GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Hero>>() {
                }
        );
        return response.getBody();
    }

    public Hero addHero(Hero newHero) {
        return rest.postForObject(serviceUrl + "/heroes", newHero, Hero.class);
    }
}

package com.filipmorawski.gitapi.simplegitapi;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GitClient {
    private String oAuthToken;
    private RestTemplate restTemplate;
    private String basicQuery;
    private String tokenParam;
    private String repoQuery;

    public GitClient() {
        this.oAuthToken = "798ec83f9d2b9938fbee0a7c1a83adc7a9392458";
        this.restTemplate = new RestTemplate();
        this.tokenParam = "?oauth_token=";
        this.basicQuery = "https://api.github.com/users/FilipMorawski";
        this.repoQuery = "/repos";
    }

    public String getUserData() {
        String getUserDataQuery = basicQuery + tokenParam + oAuthToken;
        String object = restTemplate.getForObject(getUserDataQuery, String.class);
        return object;
    }

    public String getUserReposData() {
        String getUserReposData = basicQuery + repoQuery + tokenParam + oAuthToken;
        String object = restTemplate.getForObject(getUserReposData, String.class);
        return object;
    }
}

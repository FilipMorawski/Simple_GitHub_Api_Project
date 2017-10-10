package com.filipmorawski.gitapi.simplegitapi;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/GitHubData")
public class GitController {
    private GitClient gitClient;
    private JsonParser jsonParser;
    private AnswerGenerator generator;

    public GitController(GitClient gitClient, JsonParser jsonParser, AnswerGenerator generator) {
        this.gitClient = gitClient;
        this.jsonParser = jsonParser;
        this.generator = generator;
    }

    @RequestMapping("/user")
    public String getUserData() {
        HashMap<String, String> userData = jsonParser.getUserData();
        String answer = generator.getUserDataAnswer(userData);
        return answer;
    }

    @RequestMapping("user/repos")
    public String getUserReposData() {
        ArrayList<HashMap> userData = jsonParser.getUserReposData();
        String answer = generator.getUserReposAnswer(userData);
        return answer;
    }

    @RequestMapping("user/repos/{repoName}")
    public String getSpecificRepoData(
            @PathVariable String repoName
    ) {
        getUserReposData();
        String answer = generator.getSpecificRepoAnswer(repoName);
        return answer;
    }
}

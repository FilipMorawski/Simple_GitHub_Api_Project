package com.filipmorawski.gitapi.simplegitapi;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class JsonParser {
    private JSONParser jsonParser;
    private GitClient gitClient;

    public JsonParser(GitClient gitClient) {
        this.jsonParser = new JSONParser();
        this.gitClient = gitClient;

    }

    public HashMap<String, String> getUserData() {
        HashMap<String, String> userData = new HashMap<>();
        try {
            Object obj = jsonParser.parse(gitClient.getUserData());
            JSONObject data = (JSONObject) obj;

            String name = (String) data.get("name");
            userData.put("name", name);

            String location = (String) data.get("location");
            userData.put("location", location);

            String email = (String) data.get("email");
            userData.put("email", email);

            long repos = (long) data.get("public_repos");
            String public_repos = String.valueOf(repos);
            userData.put("public_repos", public_repos);

            boolean hireable = (boolean) data.get("hireable");
            if (hireable) {
                userData.put("hireable", "Tak");
            } else {
                userData.put("hireable", "Nie");
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }
        return userData;
    }

    public ArrayList<HashMap> getUserReposData() {
        ArrayList<HashMap> userRepos = new ArrayList<>();
        try {
            Object obj = jsonParser.parse(gitClient.getUserReposData());
            JSONArray repos = (JSONArray) obj;

            for (int i=0; i<repos.size(); i++) {
                JSONObject data = (JSONObject) repos.get(i);
                HashMap<String, String> userRepoData = new HashMap<>();

                String name = (String) data.get("name");
                userRepoData.put("name", name);

                String url = (String) data.get("html_url");
                userRepoData.put("url", url);

                String description = (String) data.get("description");
                userRepoData.put("description", description);

                String language = (String) data.get("language");
                userRepoData.put("language", language);

                String createdAt = (String) data.get("created_at");
                userRepoData.put("created_at", createdAt);

                String lastUpdated = (String) data.get("pushed_at");
                userRepoData.put("updated_at", lastUpdated);

                userRepos.add(userRepoData);
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }

        return userRepos;
    }

}

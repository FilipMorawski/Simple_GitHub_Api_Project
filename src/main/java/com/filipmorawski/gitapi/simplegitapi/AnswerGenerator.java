package com.filipmorawski.gitapi.simplegitapi;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class AnswerGenerator {
    private String answer;
    private ArrayList<String> answerList;


    public String getUserDataAnswer(HashMap<String, String> userData) {
        answer = "";
        String name = userData.get("name");
        String stringName = "Nazwa użytkownika : " + name + "\n";

        String location = userData.get("location");
        String stringLocation = "Lokalizacja : " + location + "\n";

        String email = userData.get("email");
        String stringEmail = "Email : " + email + "\n";

        String repos = userData.get("public_repos");
        String stringRepos = "Liczba repozytoriów : " + repos + "\n";

        String hireable = userData.get("hireable");
        String stringHireable = "Możliwość zatrudnienia : " + hireable + "\n";

        answer = stringName + stringLocation + stringEmail + stringRepos + stringHireable;

        return answer;
    }

    public String getUserReposAnswer(ArrayList<HashMap> userRepos) {
        answer = "";
        answerList = new ArrayList<>();
        String repoAnswer;
        for (HashMap<String, String> repo : userRepos) {

            String name = repo.get("name");
            String stringName = "Nazwa Repozytorium : " + name + "\n";

            String url = repo.get("url");
            String stringUrl = "URL : " + url + "\n";

            String description = repo.get("description");
            String stringDescription = "Opis : " + description + "\n";

            String language = repo.get("language");
            String stringLanguage = "Język programowania : " + language + "\n";

            String created_at = repo.get("created_at");
            String stringCreated = "Data utworzenia : " + created_at + "\n";

            String lastUpdated = repo.get("updated_at");
            String stringUpdate = "Ostatnio aktualizowany : " + lastUpdated + "\n";

            repoAnswer = stringName + stringUrl + stringDescription + stringLanguage + stringCreated + stringUpdate + "\n" + "\n";
            answerList.add(repoAnswer);
        }
        for (int i = 0; i < answerList.size(); i++) {
            answer += answerList.get(i);
        }

        return answer;
    }

    public String getSpecificRepoAnswer(String name) {
        String repoAnswer = "There is no such Repository!";
        for (String answer : answerList) {
            if (answer.contains(name)) {
                repoAnswer = answer;
            }
        }
        return repoAnswer;
    }

}

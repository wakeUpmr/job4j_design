package ru.job4j.serialization.json;

import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final Show houseOfCards = new Show(true, 6, new Cast("Kevin Spacey"),
                new String[] {"Drama", "Political Thriller"});

        final Gson gson = new Gson();
        final String showJson = gson.toJson(houseOfCards);
        System.out.println(showJson);

        JSONObject jsonCast = new JSONObject("{\"name\":\"Kevin Spacey\"}");
        List<String> list = new ArrayList<>();
        list.add("Drama");
        list.add("Political Thriller");
        JSONArray jsonGenres = new JSONArray(list);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("closed", houseOfCards.isClosed());
        jsonObject.put("seasonNumber", houseOfCards.getSeasonNumber());
        jsonObject.put("cast", jsonCast);
        jsonObject.put("genres", jsonGenres);
        System.out.println(jsonObject);
        System.out.println(new JSONObject(houseOfCards));
    }
}
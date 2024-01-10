package ru.job4j.serialization.json;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        final Show houseOfCards = new Show(true, 6, new Cast("Kevin Spacey"),
                new String[] {"Drama", "Political Thriller"});
        final Gson gson = new Gson();
        final String showJson = gson.toJson(houseOfCards);
        System.out.println(showJson);
        final Show showMod = gson.fromJson(showJson, Show.class);
        System.out.println(showMod);
    }
}

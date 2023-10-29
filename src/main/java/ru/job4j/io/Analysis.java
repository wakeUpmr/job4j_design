package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
            BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            String str;
            boolean flag = false;
            while ((str = reader.readLine()) != null) {
                String[] line = str.split(" ");
                boolean isWork = Integer.parseInt(line[0]) < 400;
                if (flag == isWork) {
                    flag = !flag;
                    writer.append(line[1]).append(";").append(flag ? "" : System.lineSeparator());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
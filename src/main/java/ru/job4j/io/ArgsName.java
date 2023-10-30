package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        validateKey(key);
        return values.get(key);
    }

    private void parse(String[] args) {
        for (String arg : args) {
            String[] value = arg.split("=", 2);
            values.putIfAbsent(value[0].substring(1), value[1]);
        }
    }

    public static ArgsName of(String[] args) {
        validateArgs(args);
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public void validateKey(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException("This key: '%s' is missing".formatted(key));
        }
    }

    public static void validateArgs(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        for (String str : args) {
            if (!str.contains("=")) {
                throw new IllegalArgumentException(
                        "Error: This argument '%s' does not contain an equal sign".formatted(str));
            }
            String[] value = str.split("=", 2);
            if (value[0].substring(1).isBlank()) {
                throw new IllegalArgumentException(
                        "Error: This argument '%s' does not contain a key".formatted(str));
            }
            if (!value[0].startsWith("-")) {
                throw new IllegalArgumentException(
                        "Error: This argument '%s' does not start with a '-' character".formatted(str));
            }
            if (value[1].isBlank()) {
                throw new IllegalArgumentException(
                        "Error: This argument '%s' does not contain a value".formatted(str));
            }
        }
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
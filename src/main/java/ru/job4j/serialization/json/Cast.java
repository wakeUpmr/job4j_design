package ru.job4j.serialization.json;

public class Cast {
    private final String name;

    public Cast(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cast{"
                + "name='" + name + '\''
                + '}';
    }
}
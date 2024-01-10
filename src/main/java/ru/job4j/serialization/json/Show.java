package ru.job4j.serialization.json;

import java.util.Arrays;

public class Show {
    private final boolean closed;
    private final int seasonNumber;
    private final Cast cast;
    private final String[] genre;

    public Show(boolean closed, int seasonNumber, Cast cast, String[] genre) {
        this.closed = closed;
        this.seasonNumber = seasonNumber;
        this.cast = cast;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Show{"
                + "closed=" + closed
                + ", seasonNumber=" + seasonNumber
                + ", cast=" + cast
                + ", genre=" + Arrays.toString(genre)
                + '}';
    }
}

package ru.job4j.serialization.json;

import java.util.Arrays;

public class Show {
    private final boolean closed;
    private final int seasonNumber;
    private final Cast cast;
    private final String[] genres;

    public Show(boolean closed, int seasonNumber, Cast cast, String[] genres) {
        this.closed = closed;
        this.seasonNumber = seasonNumber;
        this.cast = cast;
        this.genres = genres;
    }

    public boolean isClosed() {
        return closed;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    @Override
    public String toString() {
        return "Show{"
                + "closed=" + closed
                + ", seasonNumber=" + seasonNumber
                + ", cast=" + cast
                + ", genres=" + Arrays.toString(genres)
                + '}';
    }
}
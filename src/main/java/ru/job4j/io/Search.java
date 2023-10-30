package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        validate(args);
        Path start = Paths.get(args[0]);
        search(start, p -> p.toFile().getName().endsWith(args[1]))
                .forEach(System.out::println);
    }

    private static void validate(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Number of arguments is not equal to two.");
        }
        if (!Files.isDirectory(Paths.get(args[0]))) {
            throw new IllegalArgumentException("Error: argument '%s' is not a directory.".formatted(args[0]));
        }
        if (!args[1].startsWith(".")) {
            throw new IllegalArgumentException("Error: argument '%s' is not an extension.".formatted(args[1]));
        }
    }
    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
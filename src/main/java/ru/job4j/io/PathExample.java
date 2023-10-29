package ru.job4j.io;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {
    public static void main(String[] args) throws IOException {
        Path dir = Paths.get("path/paths");
        if (!Files.exists(dir)) {
            Files.createDirectories(dir);
        }
        Path path = Path.of("path/paths/path.txt");
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        System.out.println("Файл/директория существует?: " + Files.exists(path));
        System.out.println("Это директория?: " + Files.isDirectory(path));
        System.out.println("Это файл?: " + Files.isRegularFile(path));
        System.out.println("Имя файла: " + path.getFileName());
        System.out.println("Путь к файлу абсолютный?: " + path.isAbsolute());
        System.out.println("Родительская директория файла: " + path.getParent());
        System.out.println("Абсолютный путь к файлу: " + path.toAbsolutePath());
        System.out.println("Абсолютный путь к директории: " + dir.toAbsolutePath());
        System.out.println("Доступен для чтения?: " + Files.isReadable(path));
        System.out.println("Доступен для записи?: " + Files.isWritable(path));

        Path newPath = Path.of("path/path.txt");
        if (!Files.exists(newPath)) {
            Files.move(path, newPath);
        }

        Path target = Paths.get("path");
        DirectoryStream<Path> paths = Files.newDirectoryStream(target);
        paths.forEach(System.out::println);

        Files.delete(newPath);
        Files.delete(dir);
        Files.delete(dir.getParent());
    }
}
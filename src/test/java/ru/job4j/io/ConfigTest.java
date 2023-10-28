package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Egor Krivonos");
    }

    @Test
    void whenPairWithComment() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Egor Krivonos");
    }

    @Test
    void whenPairWithoutAnEqualsSign() {
        String path = "./data/pair_without_an_equals_sign.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining("Pair(nameEgor Krivonos) does not contain an equals sign");
    }

    @Test
    void whenPairDoesntContainAKey() {
        String path = "./data/pair_without_key.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining("Empty key or value pair(=Egor Krivonos)");
    }

    @Test
    void whenPairDoesntContainsAValue() {
        String path = "./data/pair_without_value.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining("Empty key or value pair(name=)");
    }

    @Test
    void whenOnlyEqualSign() {
        String path = "./data/equal_sign.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining("Empty key or value pair(=)");
    }

    @Test
    void whenPairContainsTwoEqualSigns() {
        String path = "./data/two_equal_signs.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Egor Krivonos=Seems like a nice man");
    }

}
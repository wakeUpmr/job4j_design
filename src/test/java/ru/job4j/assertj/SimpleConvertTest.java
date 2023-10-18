package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five", "six", "ten");
        assertThat(list).isNotEmpty()
                .startsWith("first", "second")
                .endsWith("six", "ten")
                .allMatch(str -> !str.startsWith("a"));
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "first", "second", "third", "apple", "keyboard", "apple");
        assertThat(set).hasSize(5)
                .containsExactlyInAnyOrder("first", "second", "third", "apple", "keyboard")
                .anySatisfy(str -> {
                    assertThat(str).isEqualTo("apple");
                    assertThat(str).isNotEqualTo("table");
                })
                .noneMatch(str -> str.length() > 10);
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("first", "second", "three", "four", "five");
        assertThat(map).hasSize(5)
                .containsKeys("first", "second", "four")
                .containsValues(1, 2, 3)
                .containsEntry("first", 0);
    }
}
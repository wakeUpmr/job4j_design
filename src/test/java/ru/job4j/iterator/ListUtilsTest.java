package ru.job4j.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.assertj.core.api.Assertions.*;

class ListUtilsTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenRemoveIf() {
        ListUtils.removeIf(input, s -> s > 1);
        assertThat(input).hasSize(1).containsSequence(1);
    }

    @Test
    void whenRemoveAll() {
        ListUtils.addAfter(input, 0, 2);
        ListUtils.addAfter(input, 1, 4);
        assertThat(input).hasSize(4).containsSequence(1, 2, 4, 3);
        ListUtils.removeAll(input, List.of(4, 2));
        assertThat(input).hasSize(2).containsSequence(1, 3);
    }

    @Test
    void whenReplaceIf() {
        ListUtils.addAfter(input, 0, 2);
        ListUtils.replaceIf(input, s -> s %  2 != 0, 10);
        assertThat(input).hasSize(3).containsSequence(10, 2, 10);
    }
}
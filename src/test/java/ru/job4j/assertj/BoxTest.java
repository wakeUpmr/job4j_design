package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isNotNull()
                .isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron");
    }

    @Test
    void isThisUnknownObject() {
        Box box = new Box(5, 11);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object");
    }

    @Test
    void whatNumberOfVerticesSphereThan0() {
        Box box = new Box(0, 10);
        int rsl = box.getNumberOfVertices();
        assertThat(rsl).isEqualTo(0);
    }

    @Test
    void whatNumberOfVerticesTetrahedronThan4() {
        Box box = new Box(4, 6);
        int rsl = box.getNumberOfVertices();
        assertThat(rsl).isEqualTo(4);
    }

    @Test
    void isExistCubeThanTrue() {
        Box box = new Box(8, 6);
        boolean rsl = box.isExist();
        assertThat(rsl).isTrue();
    }

    @Test
    void isExistUNKNOWNThanFalse() {
        Box box = new Box(7, 4);
        boolean rsl = box.isExist();
        assertThat(rsl).isFalse();
    }

    @Test
    void getAreaOfCubeThan150() {
        Box box = new Box(8, 5);
        double rsl = box.getArea();
        assertThat(rsl).isCloseTo(150.0d, withPrecision(0.001));
    }

    @Test
    void getAreaOfTetrahedronThan6Dot928() {
        Box box = new Box(4, 2);
        double rsl = box.getArea();
        assertThat(rsl).isCloseTo(6.928d, withPrecision(0.001));
    }
}
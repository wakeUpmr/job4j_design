package ru.job4j.generics;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RoleStoreTest {

    @Test
    void whenAddAndFindThenRoleIsTeacher() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Teacher"));
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("Teacher");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Teacher"));
        Role result = store.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindRoleIsTeacher() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Teacher"));
        store.add(new Role("1", "Butcher"));
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("Teacher");
    }

    @Test
    void whenReplaceThenRoleIsProgrammer() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Teacher"));
        store.replace("1", new Role("1", "Programmer"));
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("Programmer");
    }

    @Test
    void whenNoReplaceUserThenNoChangeRole() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Florist"));
        store.replace("10", new Role("10", "Miner"));
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("Florist");
    }

    @Test
    void whenDeleteUserThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Chancellor"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteRoleThenRoleIsDirector() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Director"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("Director");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Jeweler"));
        boolean result = store.replace("1", new Role("1", "Chef"));
        assertThat(result).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "TeaTester"));
        boolean result = store.replace("10", new Role("10", "President"));
        assertThat(result).isFalse();
    }
}
package com.tutorial.repository;

import com.tutorial.data.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentRepositoryTest {

    private final StudentRepository underTest;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Autowired
    StudentRepositoryTest(StudentRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    void itShouldCheckWhenStudentEmailExist() {
        // given
        String email = "j.smith@gmail.com";
        Student student = new Student(null, "john", email);
        underTest.save(student);

        // when
        boolean actual = underTest.existsByEmail(email);

        // then
        Assertions.assertThat(actual).isTrue();
    }

    @Test
    void itShouldCheckWhenStudentEmailDoesNotExist() {
        // given
        String email = "h.abbasi@gmail.com";

        // when
        boolean actual = underTest.existsByEmail(email);

        // then
        Assertions.assertThat(actual).isFalse();
    }
}
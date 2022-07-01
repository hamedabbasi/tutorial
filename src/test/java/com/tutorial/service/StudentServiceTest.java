package com.tutorial.service;

import com.tutorial.data.Student;
import com.tutorial.exception.BadRequestException;
import com.tutorial.repository.StudentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


// you can replace autoClosable and open mock configuration with this annotation.
@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    // we already tested student repository, so we should mock it here
    @Mock
    private StudentRepository studentRepository;
    private StudentService underTest;
    // private AutoCloseable autoCloseable; // (replaced by MockitoExtension in @ExtendWith annotation.)

    @BeforeEach
    void setUp() {
        // initialize all the mocks in this test class (replaced by MockitoExtension in @ExtendWith annotation.)
        // autoCloseable = MockitoAnnotations.openMocks(this); // (replaced by MockitoExtension in @ExtendWith annotation.)
        underTest = new StudentService(studentRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        // autoCloseable.close(); // (replaced by MockitoExtension in @ExtendWith annotation.)
    }

    @Test
    void canGetAllStudents() {
        // given
        underTest.getAllStudents();

        // when
        Mockito.verify(studentRepository).findAll();

        // if you change findAll to deleteAll your test will fail.
        // Mockito.verify(studentRepository).deleteAll();
    }

    @Test
    void addStudent() {
        // given
        String email = "j.smith@gmail.com";
        Student student = new Student(null, "john", email);

        // when
        underTest.addStudent(student);

        // then
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);
        // catch student from service layer and studentRepository.save(student) method.
        Mockito.verify(studentRepository).save(studentArgumentCaptor.capture());

        Student capturedStudent = studentArgumentCaptor.getValue();
        Assertions.assertThat(capturedStudent).isEqualTo(student);
    }

    @Test
    void willThrowWhenEmailIsTaken() {
        // given
        String email = "j.smith@gmail.com";
        Student student = new Student(null, "john", email);

        // when
        // then
        BDDMockito.given(studentRepository.existsByEmail(student.getEmail())).willReturn(true);
        // or you can use like this
        // BDDMockito.given(studentRepository.existsByEmail(ArgumentMatchers.anyString())).willReturn(true);

        // another way
        // Mockito.when(studentRepository.existsByEmail(student.getEmail())).thenReturn(true);

        Assertions.assertThatThrownBy(() -> underTest.addStudent(student))
                .isInstanceOf(BadRequestException.class)
                .hasMessageContaining("Email " + student.getEmail() + " taken.");

        // check student repository never save any student
        Mockito.verify(studentRepository, Mockito.never()).save(Mockito.any());
    }

    @Test
    @Disabled
    void deleteStudent() {
    }
}
package unit.com.claudio.school.registration.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;

import java.util.Optional;

import com.claudio.school.registration.exception.NotFoundData;
import com.claudio.school.registration.model.Student;
import com.claudio.school.registration.repository.StudentRepository;
import com.claudio.school.registration.service.StudentService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class GenericServiceTest {

    StudentRepository studentRepository;

    @Test
    void testElementNotFoundOnUpdate(){

        studentRepository = mock(StudentRepository.class);
        Mockito.when(studentRepository.findById(1l)).thenReturn(Optional.empty());

        StudentService studentService = new StudentService(studentRepository);

        Assertions.assertThrows(NotFoundData.class, () -> {
            studentService.update(1l, new Student());
        });

    }

    @Test
    void testElementNotFoundOnGet(){

        studentRepository = mock(StudentRepository.class);
        Mockito.when(studentRepository.findById(1l)).thenReturn(Optional.empty());

        StudentService studentService = new StudentService(studentRepository);

        Assertions.assertThrows(NotFoundData.class, () -> {
            studentService.get(1l);
        });

    }
    
}

package functionaltest.com.claudio.school.registration.controller;

import java.sql.Date;
import java.time.Instant;

import com.claudio.school.registration.SchoolRegistrationApplication;
import com.claudio.school.registration.model.Course;
import com.claudio.school.registration.model.Registration;
import com.claudio.school.registration.model.Student;
import com.claudio.school.registration.repository.CourseRepository;
import com.claudio.school.registration.repository.RegistrationRepository;
import com.claudio.school.registration.repository.StudentRepository;

import functionaltest.com.claudio.school.registration.testhelper.WebTestClientSetup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SchoolRegistrationApplication.class)
@ContextConfiguration(classes = {WebTestClientSetup.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RegistrationControllerTest {

    private WebTestClient webClient;

    @Autowired
    private WebTestClientSetup webTestClientSetup;

    @LocalServerPort
    private int port;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @BeforeEach
    public void startServer() {
        this.webClient = webTestClientSetup.getClient(port);
    }

    @Order(1)
    @Test
    void registerStudentOnCourse() throws Exception {
        Student s = new Student();
        s.setDateOfBirthday(new Date(Instant.now().toEpochMilli()));
        s.setName("Student 999");
        s = this.studentRepository.save(s);

        Course c = new Course();
        c.setName("Course 1000");

        c = this.courseRepository.save(c);


        webClient.get()
                .uri("/registration/course/"+c.getId()+"/student/"+s.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo("Student "+s.getName()+" has enrolled to the course "+c.getName());
                
    }

    @Order(2)
    @Test
    void studentReachMaxCourse() {
        Student s = new Student();
        s.setDateOfBirthday(new Date(Instant.now().toEpochMilli()));
        s.setName("Student 999");
        s = this.studentRepository.save(s);

        for (int i=0; i<5;i++) {
            Course c = new Course();
            c.setName("Course 100"+i);
            this.courseRepository.save(c);
            Registration r = new Registration();
            r.setCourse(c);
            r.setStudent(s);

            this.registrationRepository.save(r);
        }

        Course c6 = new Course();
        c6.setName("Course 6");

        this.courseRepository.save(c6);

        webClient.get()
                .uri("/registration/course/"+c6.getId()+"/student/"+s.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo("Student reached the limit of 5 courses");


    }

    @Order(3)
    @Test
    void registerStudentOnSameCourse() throws Exception {
        Student s = new Student();
        s.setDateOfBirthday(new Date(Instant.now().toEpochMilli()));
        s.setName("Student 999");
        s = this.studentRepository.save(s);

        Course c = new Course();
        c.setName("Course 1000");

        c = this.courseRepository.save(c);

        Registration r = new Registration();
        r.setCourse(c);
        r.setStudent(s);

        this.registrationRepository.save(r);


        webClient.get()
                .uri("/registration/course/"+c.getId()+"/student/"+s.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo("Student "+s.getName()+" has already enrolled to the course "+c.getName());
                
    }

    @Order(2)
    @Test
    void courseReachedLimitStudents() {
        Course c = new Course();
        c.setName("Course 1000");
        this.courseRepository.save(c);

        for (int i=0; i<50;i++) {
            
            Student s = new Student();
            s.setDateOfBirthday(new Date(Instant.now().toEpochMilli()));
            s.setName("Student 999");
            s = this.studentRepository.save(s);

            Registration r = new Registration();
            r.setCourse(c);
            r.setStudent(s);

            this.registrationRepository.save(r);
        }

        Student s51 = new Student();
        s51.setName("Course 51");
        s51.setDateOfBirthday(new Date(Instant.now().toEpochMilli()));

        s51 = this.studentRepository.save(s51);

        webClient.get()
                .uri("/registration/course/"+c.getId()+"/student/"+s51.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo("Course reached the limit of 50 students.");


    }

}

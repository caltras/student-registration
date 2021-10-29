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

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SchoolRegistrationApplication.class)
@ContextConfiguration(classes = {WebTestClientSetup.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReportControllerTest {

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
    void listStudentsOnCourse() throws Exception {

        Course c = new Course();
        c.setName("Course 1000");

        c = this.courseRepository.save(c);

        Student s = new Student();
        s.setDateOfBirthday(new Date(Instant.now().toEpochMilli()));
        s.setName("Student 999");
        s = this.studentRepository.save(s);

        Student s2 = new Student();
        s2.setDateOfBirthday(new Date(Instant.now().toEpochMilli()));
        s2.setName("Student 1000");
        s2 = this.studentRepository.save(s2);

        Registration r = new Registration();
        r.setCourse(c);
        r.setStudent(s);

        this.registrationRepository.save(r);

        r = new Registration();
        r.setCourse(c);
        r.setStudent(s2);

        this.registrationRepository.save(r);


        webClient.get()
                .uri("/admin/registrations/course/"+c.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$", Matchers.hasSize(2));
                
    }

    @Order(2)
    @Test
    void returnListCourseWithoutStudent() throws Exception {

        Course c = new Course();
        c.setName("Course 1000");

        c = this.courseRepository.save(c);

        Student s = new Student();
        s.setDateOfBirthday(new Date(Instant.now().toEpochMilli()));
        s.setName("Student 999");
        s = this.studentRepository.save(s);

        Student s2 = new Student();
        s2.setDateOfBirthday(new Date(Instant.now().toEpochMilli()));
        s2.setName("Student 1000");
        s2 = this.studentRepository.save(s2);

        Registration r = new Registration();
        r.setCourse(c);
        r.setStudent(s);

        this.registrationRepository.save(r);

        r = new Registration();
        r.setCourse(c);
        r.setStudent(s2);

        this.registrationRepository.save(r);

        Course c2 = new Course();
        c2.setName("Course No Student 1");

        c2 = this.courseRepository.save(c2);

        Course c3 = new Course();
        c3.setName("Course No Student 2");

        c3 = this.courseRepository.save(c3);


        webClient.get()
                .uri("/admin/registrations/empty-courses")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$", Matchers.hasSize(2));
                
    }

    @Order(1)
    @Test
    void returnListCourseForStudent() throws Exception {

        Course c = new Course();
        c.setName("Course 1000");

        c = this.courseRepository.save(c);

        Course c2 = new Course();
        c2.setName("Course No Student 1");

        c2 = this.courseRepository.save(c2);

        Course c3 = new Course();
        c3.setName("Course No Student 2");

        c3 = this.courseRepository.save(c3);

        Student s = new Student();
        s.setDateOfBirthday(new Date(Instant.now().toEpochMilli()));
        s.setName("Student 999");
        s = this.studentRepository.save(s);

        Registration r = new Registration();
        r.setCourse(c);
        r.setStudent(s);

        this.registrationRepository.save(r);

        r = new Registration();
        r.setCourse(c2);
        r.setStudent(s);

        this.registrationRepository.save(r);

        r = new Registration();
        r.setCourse(c3);
        r.setStudent(s);

        this.registrationRepository.save(r);


        webClient.get()
                .uri("/admin/registrations/student/"+s.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$", Matchers.hasSize(3));
                
    }

    @Order(1)
    @Test
    void returnListStudentWithouCourse() throws Exception {

        Course c = new Course();
        c.setName("Course 1000");

        c = this.courseRepository.save(c);

        Course c2 = new Course();
        c2.setName("Course No Student 1");

        c2 = this.courseRepository.save(c2);

        Course c3 = new Course();
        c3.setName("Course No Student 2");

        c3 = this.courseRepository.save(c3);

        Student s = new Student();
        s.setDateOfBirthday(new Date(Instant.now().toEpochMilli()));
        s.setName("Student 999");
        s = this.studentRepository.save(s);

        Registration r = new Registration();
        r.setCourse(c);
        r.setStudent(s);

        this.registrationRepository.save(r);

        r = new Registration();
        r.setCourse(c2);
        r.setStudent(s);

        this.registrationRepository.save(r);

        r = new Registration();
        r.setCourse(c3);
        r.setStudent(s);

        this.registrationRepository.save(r);

        Student s2 = new Student();
        s2.setDateOfBirthday(new Date(Instant.now().toEpochMilli()));
        s2.setName("Student s2");
        s2 = this.studentRepository.save(s2);

        Student s3 = new Student();
        s3.setDateOfBirthday(new Date(Instant.now().toEpochMilli()));
        s3.setName("Student s3");
        s3 = this.studentRepository.save(s3);


        webClient.get()
                .uri("/admin/registrations/no-enrolled-students")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$", Matchers.hasSize(2));
                
    }

}

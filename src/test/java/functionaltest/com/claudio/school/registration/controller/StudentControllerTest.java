package functionaltest.com.claudio.school.registration.controller;

import java.sql.Date;
import java.time.Instant;

import com.claudio.school.registration.SchoolRegistrationApplication;
import com.claudio.school.registration.model.Student;
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
import org.springframework.web.reactive.function.BodyInserters;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SchoolRegistrationApplication.class)
@ContextConfiguration(classes = {WebTestClientSetup.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentControllerTest {

    private WebTestClient webClient;

    @Autowired
    private WebTestClientSetup webTestClientSetup;

    @LocalServerPort
    private int port;

    @Autowired
    private StudentRepository repository;

    @BeforeEach
    public void startServer() {
        this.webClient = webTestClientSetup.getClient(port);
    }

    @Order(1)
    @Test
    void createStudent() throws Exception {
        String studentJson = "{\"name\": \"Alex\", \"dateOfBirthday\": \"1980-01-01\"}";
        webClient.post()
                .uri("/student")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(studentJson))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isNotEmpty()
                .jsonPath("$.name").isNotEmpty()
                .jsonPath("$.name").isEqualTo("Alex")
                .jsonPath("$.dateOfBirthday").isNotEmpty()
                .jsonPath("$.dateOfBirthday").isEqualTo("1980-01-01");
    }

    @Order(2)
    @Test
    void updateStudent() throws Exception {
        Student st = new Student();
        st.setName("Alex");
        st.setDateOfBirthday(new Date(Instant.now().toEpochMilli()));
        st = this.repository.save(st);

        String studentJson = "{\"id\":"+st.getId()+", \"name\": \"Alex Updated\", "
        +"\"dateOfBirthday\": \""+st.getDateOfBirthday().toString()+"\"}";
        webClient.put()
                .uri("/student")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(studentJson))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isNotEmpty()
                .jsonPath("$.id").isEqualTo(st.getId())
                .jsonPath("$.name").isNotEmpty()
                .jsonPath("$.name").isEqualTo("Alex Updated")
                .jsonPath("$.dateOfBirthday").isNotEmpty()
                .jsonPath("$.dateOfBirthday").isEqualTo(st.getDateOfBirthday().toString());
    }

    @Order(3)
    @Test
    void deleteStudent() throws Exception {
        webClient.delete()
                .uri("/student/1")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk();
    }

    @Order(4)
    @Test
    void getStudent() throws Exception {
        Student st = new Student();
        st.setName("ABC");
        st.setDateOfBirthday(new Date(Instant.now().toEpochMilli()));
        st = this.repository.save(st);

        webClient.get()
                .uri("/student/"+st.getId())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isNotEmpty()
                .jsonPath("$.id").isEqualTo(st.getId())
                .jsonPath("$.name").isNotEmpty()
                .jsonPath("$.name").isEqualTo("ABC")
                .jsonPath("$.dateOfBirthday").isNotEmpty()
                .jsonPath("$.dateOfBirthday").isEqualTo(st.getDateOfBirthday().toString());
    }
}

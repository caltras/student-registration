package functionaltest.com.claudio.school.registration.controller;

import com.claudio.school.registration.SchoolRegistrationApplication;
import com.claudio.school.registration.model.Course;
import com.claudio.school.registration.repository.CourseRepository;

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
class CourseControllerTest {

    private WebTestClient webClient;

    @Autowired
    private WebTestClientSetup webTestClientSetup;

    @LocalServerPort
    private int port;

    @Autowired
    private CourseRepository repository;

    @BeforeEach
    public void startServer() {
        this.webClient = webTestClientSetup.getClient(port);
    }

    @Order(1)
    @Test
    void createCourse() throws Exception {
        String courseJson = "{\"name\": \"Web development\"}";
        webClient.post()
                .uri("/course")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(courseJson))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isNotEmpty()
                .jsonPath("$.name").isNotEmpty()
                .jsonPath("$.name").isEqualTo("Web development")
                .jsonPath("$.createdAt").isNotEmpty();
    }

    @Order(2)
    @Test
    void updateCourse() throws Exception {

        Course c = new Course();
        c.setName("Web development");
        c = this.repository.save(c);

        String courseJson = "{\"id\":"+c.getId()+", \"name\": \"Web development updated\"}";
        webClient.put()
                .uri("/course")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(courseJson))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isNotEmpty()
                .jsonPath("$.id").isEqualTo(c.getId())
                .jsonPath("$.name").isNotEmpty()
                .jsonPath("$.name").isEqualTo("Web development updated")
                .jsonPath("$.createdAt").isNotEmpty();
    }

    @Order(3)
    @Test
    void deleteCourse() throws Exception {
        webClient.delete()
                .uri("/course/1")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk();
    }

    @Order(4)
    @Test
    void getCourse() throws Exception {
        Course c = new Course();
        c.setName("ABC");
        c = this.repository.save(c);

        webClient.get()
                .uri("/course/"+c.getId())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isNotEmpty()
                .jsonPath("$.id").isEqualTo(c.getId())
                .jsonPath("$.name").isNotEmpty()
                .jsonPath("$.name").isEqualTo("ABC");
    }
}

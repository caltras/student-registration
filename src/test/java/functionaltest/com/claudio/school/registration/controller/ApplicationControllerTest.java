package functionaltest.com.claudio.school.registration.controller;

import com.claudio.school.registration.SchoolRegistrationApplication;
import functionaltest.com.claudio.school.registration.testhelper.WebTestClientSetup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
class ApplicationControllerTest {

    private WebTestClient webClient;

    @Autowired
    private WebTestClientSetup webTestClientSetup;

    @LocalServerPort
    private int port;

    @BeforeEach
    public void startServer() {
        this.webClient = webTestClientSetup.getClient(port);
    }

    @Test
    void getApplicationStatus() throws Exception {
        webClient.get()
                .uri("/")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.application").isNotEmpty()
                .jsonPath("$.application").isEqualTo("school-registration")
                .jsonPath("$.buildVersion").isNotEmpty()
                .jsonPath("$.buildVersion").isEqualTo("0.0.1-SNAPSHOT-TEST");
    }
}

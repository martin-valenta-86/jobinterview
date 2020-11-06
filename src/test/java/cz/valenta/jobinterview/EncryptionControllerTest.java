package cz.valenta.jobinterview;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EncryptionControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void encrypt_givenValidInput_returnEncrypted() {
        String inputText = "Job    Interview";
        String response = restTemplate.getForObject("http://localhost:" + port + "/encrypt?text=" + inputText,
                String.class);

        assertEquals("wEivretNi BOj", response);
    }
}

// Importation des classes nécessaires
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

//Annotation indiquant qu'il s'agit d'un test Spring Boot.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MonTest{

  // Annotation pour injecter le port sur lequel le serveur a démarré.
  @LocalServerPort
  private int port;

  // Annotation pour injecter une instance de TestRestTemplate, qui est utilisée pour envoyer des requêtes HTTP.
  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void monTest() {
    //Envoie une requête GET à l'URL de mon service et stocker la réponse
    ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/mon-endpoint", String.class);

    //Vérifie que le status de la réponse est 200 (ok)
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
  }
}




// Importation des classes nécessaires
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.samples.petclinic.customers.CustomersServiceApplication;

// Cette annotation indique que le contexte de l'application Spring doit être chargé pour les tests.
// La classe CustomersServiceApplication est utilisée pour configurer le contexte.
@SpringBootTest(classes = CustomersServiceApplication.class)

// Cette annotation indique que le MockMvc doit être configuré automatiquement.
@AutoConfigureMockMvc
//MockMvc est une classe de Spring Test Framework qui permet de tester les contrôleurs Spring MVC de manière isolée. Elle simule un environnement Spring MVC pour que vous puissiez tester le comportement de vos contrôleurs sans avoir besoin de déployer votre application sur un serveur.

public class MyCustomerTest {

    // Cette annotation indique que le MockMvc doit être injecté.
    @Autowired
    private MockMvc mockMvc;

    // Cette méthode de test vérifie que la requête GET /owners/find renvoie le code d'état HTTP 200.
    @Test
    public void testFind() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/owners/1")) //Vérifie que le statut de la réponse est ok (200)
            .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

//Ce code est un test d'intégration pour une application Spring Boot. Il utilise MockMvc pour envoyer une requête GET à l'URL "/owners/1" et vérifie que le statut de la réponse est OK (200). Si le statut de la réponse est différent de 200, le test échouera.
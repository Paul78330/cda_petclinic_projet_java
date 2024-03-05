// Importe l'annotation Test de JUnit 5 (JUnit Jupiter)
import org.junit.jupiter.api.Test;

// Importe la méthode assertEquals de JUnit 5 pour les assertions
import static org.junit.jupiter.api.Assertions.assertEquals;

// Déclare une classe publique pour les tests unitaires
public class MyServerUnitTest {

   // Annoté avec @Test pour indiquer que c'est une méthode de test
  @Test
  public void simpleTest() {
    int expected = 1;

    int actual = 1;

    assertEquals(expected, actual, "The actual value should be equal to the expected one!");
  }
  
}

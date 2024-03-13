TESTS

1- Editer un test dans des micro-service et configurer le fichier pom.xml de sorte à indiquer au service quel tests éxécuter (build>pluging)

```


<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.1.2</version>
            <configuration>
                <includes>
                    <include>**/*Test.java</include>
                    <include>**/*Tests.java</include>
                    <include>**/*TestCase.java</include>
                </includes>
            </configuration>
        </plugin>
    </plugins>
</build>
```

Ajouter également les dépendances modules par service

```
<!-- Ajoutez cette dépendance pour JUnit Jupiter API-->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <scope>test</scope>
        </dependency>

        <!-- Ajoutez cette dépendance pour Spring Boot Starter Test -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
```

et mettre également à jours les version dans le pom parent

1- Pour notre test_d'intégration, nous allons éditer un Dockerfile.test dans /docker afin d'obtenir une image qui aura à la fois maven et docker

2- Configurer le docker-compose afin de définir le service test_intégration

3- Mettre à jour la config .gitlab-ci.yml pour éditer le job test_intégration

DEPLOIEMENT_STAGING

-1 Editer un fichier StagingE2ETest.java afin de faire un test de bout en bout dans un environnement de staging

-2 Ajouter les dépendances nécessaires à notre fichier pom.xml afin de pourvoir éxécuter nos test

-3 Configurer l'infrastructure as code de notre conteneur afin de pouvoir éxécuter le test dans un environnement de staging (docker-compose.staging.yml

QUALITY

1- Pour tester la qualité de notre code, nous allons installer les plugings Checkstyle, PMD et FindBugs dans notre pom.xml

PACKAGE

1- Comment récupérer la compilation des nos différents micro-services dans un dossier /target à la racine de notre projet.

but : pouvoir avoir une compilation générale des .jar des différents services afin de pouvoir empaqueter ce dossier /target situé à la racine

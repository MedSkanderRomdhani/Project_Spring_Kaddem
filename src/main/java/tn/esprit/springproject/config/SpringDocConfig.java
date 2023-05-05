package tn.esprit.springproject.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(infoAPI());
    }
    public Info infoAPI() {
        return new Info().title("SpringDoc-Demo")
                .description("TP étude de cas")
                .contact(contactAPI());
    }

    public Contact contactAPI() {
        Contact contact = new Contact().name("Equipe ASI II")
                        .email("yosra.elbich@esprit.tn")
                .url("https://www.linkedin.com/in/yosraElbich/");

        return contact;}
        @Bean
        public GroupedOpenApi contratPublicApi() {
            return GroupedOpenApi.builder()
                    .group("Contrat Controllers")
                                    .pathsToMatch("/Contrat/**")
                                    .pathsToExclude("**")
                                    .build();
}
    @Bean
    public GroupedOpenApi detailEquipePublicApi() {
        return GroupedOpenApi.builder()
                .group("Detail Equipe Controllers")
                .pathsToMatch("/DetailEquipe/**")
                .pathsToExclude("**")
                .build();
    }

    @Bean
    public GroupedOpenApi equipePublicApi() {
        return GroupedOpenApi.builder()
                .group("Equipe Controllers")
                .pathsToMatch("/Equipe/**")
                .pathsToExclude("**")
                .build();
    }

    @Bean
    public GroupedOpenApi etudiantPublicApi() {
        return GroupedOpenApi.builder()
                .group("Etudiant Controllers")
                .pathsToMatch("/Etudiant/**")
                .pathsToExclude("**")
                .build();
    }

    @Bean
    public GroupedOpenApi universitePublicApi() {
        return GroupedOpenApi.builder()
                .group("Universite Controllers")
                .pathsToMatch("/Universite/**")
                .pathsToExclude("**")
                .build();
    }

    @Bean
    public GroupedOpenApi departementPublicApi() {
        return GroupedOpenApi.builder()
                .group("Departement Controllers")
                .pathsToMatch("/Departement/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi enseignantPublicApi() {
        return GroupedOpenApi.builder()
                .group("Enseignant Controllers")
                .pathsToMatch("/Enseignant/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi modulePublicApi() {
        return GroupedOpenApi.builder()
                .group("Module Controllers")
                .pathsToMatch("/Module/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi encadrantPublicApi() {
        return GroupedOpenApi.builder()
                .group("Encadrant Controllers")
                .pathsToMatch("/Encadrant/**")
                .pathsToExclude("**")
                .build();
    }

}


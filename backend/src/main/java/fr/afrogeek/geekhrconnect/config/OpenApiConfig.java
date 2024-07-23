package fr.afrogeek.geekhrconnect.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
           contact = @Contact(
                   name = "Bastiane",
                   email = "djamenbasty1@gmail.com"
                   

           ),
           description = "OpenApi documentation for GeekHR-Connect",
           title = "OpenApi specification - GeekHR-Connect",
           version = "1.0"
    ),
    servers = @Server(
              description = "lOCAL ENV",
              url ="http://localhost:8080"
    )
)

public class OpenApiConfig {

}

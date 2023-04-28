package com.backendmongo.swagger;

import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(
        info = @Info(
                description = "Backendmongo Resources",
                version = "V12.0.12",
                title = "Backendmongo Resource API",
                contact = @Contact(
                   name = "Backendmongo Team", 
                   email = "backendmongo@hexaware.com", 
                   url = "http://www.hexaware.com"
                ),
                license = @License(
                   name = "Backendmongo 2.0", 
                   url = "http://www.hexaware.com/licenses/LICENSE-2.0"
                )
        ),
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
        externalDocs = @ExternalDocs(value = "Read This For Sure", url = "http://www.backendmongo.org")
)
public interface ApiDocumentationConfig {

}
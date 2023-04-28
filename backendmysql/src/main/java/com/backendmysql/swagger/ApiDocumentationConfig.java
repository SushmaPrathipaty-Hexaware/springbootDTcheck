package com.backendmysql.swagger;

import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(
        info = @Info(
                description = "Backendmysql Resources",
                version = "V12.0.12",
                title = "Backendmysql Resource API",
                contact = @Contact(
                   name = "Backendmysql Team", 
                   email = "backendmysql@hexaware.com", 
                   url = "http://www.hexaware.com"
                ),
                license = @License(
                   name = "Backendmysql 2.0",  
                   url = "http://www.hexaware.com/licenses/LICENSE-2.0"
                )
        ),
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
        externalDocs = @ExternalDocs(value = "Read This For Sure", url = "http://www.backendmysql.org")
)
public interface ApiDocumentationConfig {

}
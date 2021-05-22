package com.Squad.Interestellar.Central.Erros.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket centralErrosApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Central")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {

        final ApiInfo apiInfo = new ApiInfoBuilder()
                .title("Central de erros API")
                .description(
                        "API desenvolvida para o projeto central de erros proposto pela Codenation \n" +
                        "Colaboradores: \n\n" +
                        "Berilo     Git: wberilo        Email: wberilo@gmail.com\n" +
                        "Pedro      Git: PedroMarqdev   Email: pedromarqdev@gmail.com\n" +
                        "Vitor      Git: vitor-rc1      Email: vitorrc01x@gmail.com\n"
                )
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .build();

        return apiInfo;
    }
}

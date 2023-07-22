package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Adopat
 * @description 接口文档配置 swagger 访问地址 http://localhost:8080/doc.html
 * @date 2023-07-22 17:30
 */
@Configuration //必须存在
@EnableSwagger2 //必须存在
public class SwaggerConfig {
    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //对应你controller目录
                .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //指定文档标题
                .title("swagger 接口文档")
                //指定作者
                .contact(new Contact("Adopat", "", ""))
                //接口文档描述
                .description("swagger-bootstrap-ui")
                //指定在线接口文档访问url
                .termsOfServiceUrl("http://localhost:8080")
                //指定版本号
                .version("1.0")
                .build();
    }
}



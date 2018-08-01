package com.crud.tasks.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoreConfigurationTest {

    @Autowired
    CoreConfiguration coreConfiguration;

    @Test
    public void testApiReturningDocket() {
        Docket testDocket = new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.crud.tasks.controller"))
                .paths(PathSelectors.any())
                .build();
        Docket apiDocket = coreConfiguration.api();
        assertEquals(testDocket.getDocumentationType(), apiDocket.getDocumentationType());
        assertEquals(testDocket.getGroupName(), apiDocket.getGroupName());
    }
}

package org.zerock.ex1.sample.controller;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import lombok.extern.log4j.Log4j2;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Log4j2
public class SampleControllerTests {

    @Autowired(required = false)
    private TestRestTemplate testRestTemplate;

    private static final Logger logger = LogManager.getLogger(SampleControllerTests.class);
    
    @Test
    public void testHello() {

        String[] result = testRestTemplate.getForObject(
                "/api/v1/sample/hello",
                String[].class);

        logger.info(Arrays.toString(result));

    }
}

package com.ironhack.Jenkins.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JenkinsDemoApplicationTests {

    @Autowired
    private JenkinsDemoApplication jenkinsDemoApplication;

    @Test
    void contextLoads() {
        assertNotNull(jenkinsDemoApplication);
    }

    @Test
    void main() {
        JenkinsDemoApplication.main(new String[] {});
    }
}
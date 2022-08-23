package com.project.perscholaslms;

import com.project.perscholaslms.config.TestSecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest(classes = TestSecurityConfig.class)
@AutoConfigureMockMvc
public class SecuredControllerWebMvcIntegrationTest {
    @Autowired
    private MockMvc mvc;


    @WithMockUser(value = "spring")
    @Test
    public void givenAuthRequestOnPrivateService_shouldSucceedWith200() throws Exception {
        mvc.perform(get("/login").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}

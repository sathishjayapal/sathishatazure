package me.sathish.sathishatazure.domain.JobApplication.controllers;

import me.sathish.sathishatazure.domain.JobApplication.service.JobApplicationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class RoadControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    JobApplicationService roadService;

    @Test
    void index() {
    }

    @Test
    void createRoad() throws Exception {
        this.mvc.perform(
                        post("/api/createRoad")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                                        {
                                            "roadName": "JUNIT Save roadName",
                                            "city": "JUNIT City",
                                            "state": "JU"
                                        }
                                        """)
                )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", notNullValue()))
                .andExpect(jsonPath("$.roadName", is("JUNIT Save roadName")))
                .andExpect(jsonPath("$.city", is("JUNIT City")));
    }
}

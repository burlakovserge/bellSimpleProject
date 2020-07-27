package ru.bellintegrator.practice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import ru.bellintegrator.practice.AbsractMvcTest;
import ru.bellintegrator.practice.dto.organization.request.FilterRequestOrgDto;
import ru.bellintegrator.practice.dto.organization.request.SaveRequestOrgDto;
import ru.bellintegrator.practice.dto.organization.request.UpdateRequestOrgDto;

import javax.transaction.Transactional;
import java.util.regex.Pattern;

import static org.hamcrest.Matchers.matchesPattern;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class OrganizationControllerTest extends AbsractMvcTest {
    @Autowired
    ObjectMapper mapper;

    @Override
    protected void doInit() throws Exception {
        //
    }

    @Test
    public void saveOrganization() throws Exception {
        SaveRequestOrgDto requestOrganization = new SaveRequestOrgDto(
                "name", "000", "123", "d58ss65", "Moscow",
                "123456", true
        );

        String jsonRequest = mapper.writeValueAsString(requestOrganization);

        MvcResult result = mockMvc
                .perform(post("/api/organization/save")
                        .content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk()).andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    public void getOrganization() throws Exception {

        mockMvc.perform(get("/api/organization/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("data.phone").value("+7 (8442) 50 - 42 - 13"))
                .andExpect(jsonPath("data.inn").value("3435880067"));
    }

    @Test
    public void getOrganization_withIncorrectId() throws Exception {

        String regex = "error code \\w{4}";
        Pattern pattern = Pattern.compile(regex);

        mockMvc.perform(get("/api/organization/200")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("error", matchesPattern(pattern)));
    }

    @Test
    public void getAll_3param() throws Exception {
        FilterRequestOrgDto filterDto = new FilterRequestOrgDto("VVS", "34350001112", true);

        String jsonRequest = mapper.writeValueAsString(filterDto);

        mockMvc.perform(post("/api/organization/list")
                .content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.[0].name").value("VVS"))
                .andExpect(jsonPath("$.data.[0].id").value(1))
                .andExpect(jsonPath("$.data.[0].isActive").value(true));
    }

    @Test
    public void getAll_2param() throws Exception {
        FilterRequestOrgDto filterDto = new FilterRequestOrgDto("VVS", null, true);

        String jsonRequest = mapper.writeValueAsString(filterDto);

        mockMvc.perform(post("/api/organization/list")
                .content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.[0].name").value("VVS"))
                .andExpect(jsonPath("$.data.[0].id").value(1))
                .andExpect(jsonPath("$.data.[0].isActive").value(true))
                .andExpect(jsonPath("$.data.[1].name").value("VVS"))
                .andExpect(jsonPath("$.data.[1].id").value(5))
                .andExpect(jsonPath("$.data.[1].isActive").value(true));
    }

    @Test
    public void getAll_1param() throws Exception {
        FilterRequestOrgDto filterDto = new FilterRequestOrgDto("VVS", null, null);

        String jsonRequest = mapper.writeValueAsString(filterDto);

        mockMvc.perform(post("/api/organization/list")
                .content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.[0].name").value("VVS"))
                .andExpect(jsonPath("$.data.[0].id").value(1))
                .andExpect(jsonPath("$.data.[0].isActive").value(true))
                .andExpect(jsonPath("$.data.[1].name").value("VVS"))
                .andExpect(jsonPath("$.data.[1].id").value(4))
                .andExpect(jsonPath("$.data.[1].isActive").value(false))
                .andExpect(jsonPath("$.data.[2].name").value("VVS"))
                .andExpect(jsonPath("$.data.[2].id").value(5))
                .andExpect(jsonPath("$.data.[2].isActive").value(true));
    }

    @Test
    @Transactional
    public void updateOrganization() throws Exception {
        UpdateRequestOrgDto updateDto = new UpdateRequestOrgDto(
                2, "name", "000", "123", "d58ss65", "Moscow",
                "123456", true);

        String jsonRequest = mapper.writeValueAsString(updateDto);

        MvcResult result = mockMvc
                .perform(post("/api/organization/update")
                        .content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());

    }
}


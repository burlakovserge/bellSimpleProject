package ru.bellintegrator.practice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import ru.bellintegrator.practice.AbsractMvcTest;
import ru.bellintegrator.practice.dto.person.request.FilterRequestPersonDto;
import ru.bellintegrator.practice.dto.person.request.SaveRequestPersonDto;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class PersonControllerTest extends AbsractMvcTest {
    @Autowired
    ObjectMapper mapper;

    @Test
    public void getPerson() throws Exception {
        mockMvc.perform(get("/api/user/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("data.phone").value("+79991112323"))
                .andExpect(jsonPath("data.docNumber").value("1812555555"))
                .andExpect(jsonPath("data.citizenshipCode").value("112"));
    }

    @Test
    public void addPerson() throws Exception {
        SaveRequestPersonDto person = new SaveRequestPersonDto(
                5, "Сергей", "Бурлаков", "Викторович", "Собственник",
                "+79064102579", "21", "1800777777",
                LocalDate.of(2010, 6, 7), "643", true);

        String jsonRequest = mapper.writeValueAsString(person);

        mockMvc.perform(post("/api/user/save")
                .content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("data.result").value("success"));
    }

    @Test
    public void addPerson_onlyRequiredParams() throws Exception {
        SaveRequestPersonDto person = new SaveRequestPersonDto(
                5, "Сергей", null, null, "Собственник", null,
                null, null, null, null, null);

        String jsonRequest = mapper.writeValueAsString(person);

        mockMvc.perform(post("/api/user/save")
                .content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("data.result").value("success"));

    }

    @Test
    public void getList() throws Exception {
        FilterRequestPersonDto filterDto = new FilterRequestPersonDto(
                1, null, null, null, null, null,
                null);

        String jsonRequest = mapper.writeValueAsString(filterDto);

        mockMvc.perform(post("/api/user/list")
                .content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.[0].firstName").value("Dmitry"))
                .andExpect(jsonPath("$.data.[0].id").value(1))
                .andExpect(jsonPath("$.data.[1].firstName").value("Irina"))
                .andExpect(jsonPath("$.data.[1].id").value(2));
    }

}
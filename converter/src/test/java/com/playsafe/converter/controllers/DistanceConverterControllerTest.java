package com.playsafe.converter.controllers;

import com.playsafe.converter.services.DistanceConverter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(DistanceConverterController.class)
class DistanceConverterControllerTest {

    private static final String JSON = "application/json";
    @MockBean
    private DistanceConverter distanceConverter;
    private static final String BASE_URL = "/conversions";
    @Autowired
    private MockMvc mvc;

    @Test
    void toMiles() throws Exception {
        when(distanceConverter.toMiles(anyDouble())).thenReturn(621.37);
        MockHttpServletResponse response = mvc.perform(get(BASE_URL.concat("/ktom"))
                .param("value","1000")
                .accept(JSON))
                .andReturn().getResponse();
        assertNotNull(response);
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("621.37");
        verify(distanceConverter).toMiles(anyDouble());
    }

    @Test
    void toKilometer() throws Exception {
        when(distanceConverter.toKilometer(anyDouble())).thenReturn(1000.0);
        MockHttpServletResponse response = mvc.perform(get(BASE_URL.concat("/mtok"))
                .param("value","621.37")
                .accept(JSON))
                .andReturn().getResponse();
        assertNotNull(response);
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("1000.0");
        verify(distanceConverter).toKilometer(anyDouble());
    }

}
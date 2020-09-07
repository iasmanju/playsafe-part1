package com.playsafe.converter.controllers;

import com.playsafe.converter.services.TempConverter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(TemperatureConversionController.class)
class TemperatureConversionControllerTest {

    @MockBean
    private TempConverter tempConverter;
    private static final String BASE_URL = "/conversions";
    @Autowired
    private MockMvc mvc;
    private static final String JSON = "application/json";

    @Test
    void toKelVin() throws Exception {
        when(tempConverter.toKelvin(anyDouble())).thenReturn(373.15);
        MockHttpServletResponse response = mvc.perform(get(BASE_URL.concat("/ctok"))
                .param("value","100")
                .accept(JSON))
                .andReturn().getResponse();
        assertNotNull(response);
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("373.15");
        verify(tempConverter).toKelvin(anyDouble());
    }

    @Test
    void toCelsius() throws Exception {
        when(tempConverter.toCelsius(anyDouble())).thenReturn(100.0);
        MockHttpServletResponse response = mvc.perform(get(BASE_URL.concat("/ktoc"))
                .param("value","373.15")
                .accept(JSON))
                .andReturn().getResponse();
        assertNotNull(response);
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("100.0");
        verify(tempConverter).toCelsius(anyDouble());
    }

}
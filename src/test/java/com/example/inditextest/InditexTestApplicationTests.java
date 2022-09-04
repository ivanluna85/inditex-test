package com.example.inditextest;

import com.example.inditextest.dto.PriceRequest;
import com.example.inditextest.util.FormatConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest (classes = InditexTestApplication.class)
@AutoConfigureMockMvc
class InditexTestApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test1() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post("/inditex/prices")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(
                                PriceRequest.builder()
                                        .applicationDate(LocalDateTime.parse("2020-06-14 10:00:00", DateTimeFormatter.ofPattern(FormatConstants.DATE_FORMAT)))
                                        .productCode(35455l)
                                        .brandId(1l)
                                        .build())))
                        .andExpect(status().isOk())
                        .andExpect(content()
                                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                        .andExpect(jsonPath("$.price.product_code").value(35455))
                        .andExpect(jsonPath("$.price.brand").value("ZARA"))
                        .andExpect(jsonPath("$.price.price_list").value(1))
                        .andExpect(jsonPath("$.price.start_date").value("2020-06-14 00:00:00"))
                        .andExpect(jsonPath("$.price.end_date").value("2020-12-31 23:59:59"))
                        .andExpect(jsonPath("$.price.price").value(35.50000))
                        .andExpect(jsonPath("$.price.curr").value("EUR"));

    }

    @Test
    void test2() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post("/inditex/prices")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(
                                PriceRequest.builder()
                                        .applicationDate(LocalDateTime.parse("2020-06-14 16:00:00", DateTimeFormatter.ofPattern(FormatConstants.DATE_FORMAT)))
                                        .productCode(35455l)
                                        .brandId(1l)
                                        .build())))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.price.product_code").value(35455))
                .andExpect(jsonPath("$.price.brand").value("ZARA"))
                .andExpect(jsonPath("$.price.price_list").value(2))
                .andExpect(jsonPath("$.price.start_date").value("2020-06-14 15:00:00"))
                .andExpect(jsonPath("$.price.end_date").value("2020-06-14 18:30:00"))
                .andExpect(jsonPath("$.price.price").value(25.45000))
                .andExpect(jsonPath("$.price.curr").value("EUR"));

    }

    @Test
    void test3() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post("/inditex/prices")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(
                                PriceRequest.builder()
                                        .applicationDate(LocalDateTime.parse("2020-06-14 21:00:00", DateTimeFormatter.ofPattern(FormatConstants.DATE_FORMAT)))
                                        .productCode(35455l)
                                        .brandId(1l)
                                        .build())))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.price.product_code").value(35455))
                .andExpect(jsonPath("$.price.brand").value("ZARA"))
                .andExpect(jsonPath("$.price.price_list").value(1))
                .andExpect(jsonPath("$.price.start_date").value("2020-06-14 00:00:00"))
                .andExpect(jsonPath("$.price.end_date").value("2020-12-31 23:59:59"))
                .andExpect(jsonPath("$.price.price").value(35.50000))
                .andExpect(jsonPath("$.price.curr").value("EUR"));

    }

    @Test
    void test4() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post("/inditex/prices")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(
                                PriceRequest.builder()
                                        .applicationDate(LocalDateTime.parse("2020-06-15 10:00:00", DateTimeFormatter.ofPattern(FormatConstants.DATE_FORMAT)))
                                        .productCode(35455l)
                                        .brandId(1l)
                                        .build())))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.price.product_code").value(35455))
                .andExpect(jsonPath("$.price.brand").value("ZARA"))
                .andExpect(jsonPath("$.price.price_list").value(3))
                .andExpect(jsonPath("$.price.start_date").value("2020-06-15 00:00:00"))
                .andExpect(jsonPath("$.price.end_date").value("2020-06-15 11:00:00"))
                .andExpect(jsonPath("$.price.price").value(30.50000))
                .andExpect(jsonPath("$.price.curr").value("EUR"));

    }

    @Test
    void test5() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post("/inditex/prices")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(
                                PriceRequest.builder()
                                        .applicationDate(LocalDateTime.parse("2020-06-16 21:00:00", DateTimeFormatter.ofPattern(FormatConstants.DATE_FORMAT)))
                                        .productCode(35455l)
                                        .brandId(1l)
                                        .build())))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.price.product_code").value(35455))
                .andExpect(jsonPath("$.price.brand").value("ZARA"))
                .andExpect(jsonPath("$.price.price_list").value(4))
                .andExpect(jsonPath("$.price.start_date").value("2020-06-15 16:00:00"))
                .andExpect(jsonPath("$.price.end_date").value("2020-12-31 23:59:59"))
                .andExpect(jsonPath("$.price.price").value(30.50000))
                .andExpect(jsonPath("$.price.curr").value("EUR"));

    }


    @Test
    void testNotFound() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post("/inditex/prices")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(
                                PriceRequest.builder()
                                        .applicationDate(LocalDateTime.parse("2020-06-13 21:00:00", DateTimeFormatter.ofPattern(FormatConstants.DATE_FORMAT)))
                                        .productCode(35455l)
                                        .brandId(1l)
                                        .build())))
                .andExpect(status().isNotFound())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.msg").value("No existe registro para la cadena 1, codigo producto 35455 y fecha 2020-06-13 21:00:00"));

    }


    @Test
    void testEmptyRequest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post("/inditex/prices")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(
                                PriceRequest.builder()
                                        .applicationDate(null)
                                        .productCode(null)
                                        .brandId(1l)
                                        .build())))
                .andExpect(status().isFailedDependency())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.msg").value("No se enviaron todos los datos"));

    }

}

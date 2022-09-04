package com.example.inditextest.controller;

import com.example.inditextest.dto.PriceRequest;
import com.example.inditextest.dto.PriceResponse;
import com.example.inditextest.exception.PricesNotFoundException;
import com.example.inditextest.exception.PricesRequestException;
import com.example.inditextest.service.PricesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/inditex")
public class PricesController {
    private final PricesService pricesService;

    @Autowired
    public PricesController(PricesService pricesService) {
        this.pricesService = pricesService;
    }

    @PostMapping("/prices")
    public ResponseEntity<Map> getSite(@RequestBody PriceRequest request) {
        HttpStatus status = HttpStatus.OK;
        Map response = new HashMap();
        PriceResponse priceResponse = null;

        try {
            priceResponse = pricesService.search(request);
        } catch (PricesNotFoundException e) {
            log.error(e.getMessage());
            status = HttpStatus.NOT_FOUND;
            response.put("msg", e.getMessage());
        } catch (PricesRequestException e) {
            log.error(e.getMessage());
            status = HttpStatus.FAILED_DEPENDENCY;
            response.put("msg", e.getMessage());
        }
        response.put("price", priceResponse);

        return new ResponseEntity<>(response, status);
    }
}
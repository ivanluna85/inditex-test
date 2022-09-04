package com.example.inditextest.service;

import com.example.inditextest.dto.PriceRequest;
import com.example.inditextest.dto.PriceResponse;
import com.example.inditextest.entity.Prices;
import com.example.inditextest.exception.PricesNotFoundException;
import com.example.inditextest.exception.PricesRequestException;
import com.example.inditextest.repository.PricesRepository;
import com.example.inditextest.util.FormatConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class PricesService {

    private PricesRepository pricesRepository;

    @Autowired
    public PricesService(PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    public PriceResponse search(PriceRequest request) throws PricesNotFoundException, PricesRequestException {
        validateRequest(request);
        Prices prices = pricesRepository.findFirstByBrandIdAndProductCodeAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriceListDesc(request.getBrandId(), request.getProductCode(), request.getApplicationDate(), request.getApplicationDate())
                .orElseThrow(() -> new PricesNotFoundException(String.format("No existe registro para la cadena %d, codigo producto %d y fecha %s", request.getBrandId(), request.getProductCode(),
                        request.getApplicationDate().format(DateTimeFormatter.ofPattern(FormatConstants.DATE_FORMAT)))));

        return PriceResponse.builder()
                .brand(prices.getBrand().getName())
                .productCode(prices.getProduct().getCode())
                .price(prices.getPrice())
                .curr(prices.getCurr())
                .endDate(prices.getEndDate())
                .startDate(prices.getStartDate())
                .priceList(prices.getPriceList())
                .build();
    }

    private void validateRequest(PriceRequest request) throws PricesRequestException {
        if (Optional.ofNullable(request.getApplicationDate()).isEmpty() ||
                Optional.ofNullable(request.getBrandId()).isEmpty() ||
                Optional.ofNullable(request.getProductCode()).isEmpty()) {
            throw new PricesRequestException("No se enviaron todos los datos");
        }
    }
}

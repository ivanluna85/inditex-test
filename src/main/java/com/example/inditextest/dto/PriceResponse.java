package com.example.inditextest.dto;

import com.example.inditextest.util.FormatConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class PriceResponse {

    @JsonProperty("product_code")
    private Long productCode;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("price_list")
    private Long priceList;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = FormatConstants.DATE_FORMAT)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonProperty("start_date")
    private LocalDateTime startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = FormatConstants.DATE_FORMAT)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonProperty("end_date")
    private LocalDateTime endDate;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("curr")
    private String curr;
}

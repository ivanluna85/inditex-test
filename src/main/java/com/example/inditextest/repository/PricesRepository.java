package com.example.inditextest.repository;

import com.example.inditextest.entity.Prices;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PricesRepository extends JpaRepository<Prices, Long> {

    Optional<Prices> findFirstByBrandIdAndProductCodeAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriceListDesc(Long brandId, Long productId, LocalDateTime startDate, LocalDateTime EndDate);

}

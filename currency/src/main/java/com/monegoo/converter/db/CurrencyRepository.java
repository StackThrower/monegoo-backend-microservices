package com.monegoo.converter.db;

import com.monegoo.converter.db.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
    Currency findTopByOrderByIdDesc();
}

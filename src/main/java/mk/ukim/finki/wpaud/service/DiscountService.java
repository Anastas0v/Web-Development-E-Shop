package mk.ukim.finki.wpaud.service;

import mk.ukim.finki.wpaud.model.Discount;
import mk.ukim.finki.wpaud.model.dto.DiscountDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface DiscountService
{
    List<Discount> findAll();

    Page<Discount> findAllWithPagination(Pageable pageable);

    Optional<Discount> findById(Long id);

    Optional<Discount> save(DiscountDTO discountDTO);

    Optional<Discount> edit(Long id, DiscountDTO discountDTO);

    void deleteById(Long id);

    Optional<Discount> assignDiscount(String username, Long discountId);
}
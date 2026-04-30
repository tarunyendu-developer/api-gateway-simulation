package com.gateway.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {

    private Long id;

    @NotNull(message = "UserId is required")
    private Long userId;

    @NotBlank(message = "Product is required")
    private String product;

    @NotNull(message = "Quantity is required")
    private Integer quantity;

    @NotNull(message = "Total price is required")
    private Double totalPrice;

    @NotBlank(message = "Status is required")
    private String status;
}
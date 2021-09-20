package io.javabee.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PriceDTO {

    double listPrice;
    double salePrice;
    boolean onSale;

}

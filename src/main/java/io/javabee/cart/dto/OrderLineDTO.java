package io.javabee.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderLineDTO {

    String id;

    String productId;

    String skuId;

    long quantity;

    double price;

    String userId;

    String state;

}

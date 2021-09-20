package io.javabee.cart.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartDTO {

    List<OrderLineDTO> orderLines = new ArrayList<>();

    double cartTotal;
}

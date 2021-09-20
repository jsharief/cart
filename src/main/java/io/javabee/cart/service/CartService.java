package io.javabee.cart.service;

import java.util.Optional;

import io.javabee.cart.dto.CartDTO;
import io.javabee.cart.dto.OrderLineDTO;

public interface CartService {

    public Optional<CartDTO> getCart(String userId);

    public Optional<CartDTO> addItemToCart(OrderLineDTO dto);
}

package io.javabee.cart.dao;

import java.util.List;
import java.util.Optional;

import io.javabee.cart.documents.OrderLine;
import io.javabee.cart.dto.OrderLineDTO;

public interface OrderLineDao {

    public Optional<OrderLineDTO> addItemToCart(OrderLine line);

    public List<OrderLineDTO> getCurrentCart(String pUserId);

}

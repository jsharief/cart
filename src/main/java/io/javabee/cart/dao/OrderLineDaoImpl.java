package io.javabee.cart.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import io.javabee.cart.documents.OrderLine;
import io.javabee.cart.dto.OrderLineDTO;
import io.javabee.cart.helper.Util;
import io.javabee.cart.repository.OrderLineRepository;

@Component
public class OrderLineDaoImpl implements OrderLineDao {

    OrderLineRepository orderLineRepository;

    OrderLineDaoImpl(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }

    @Override
    public Optional<OrderLineDTO> addItemToCart(OrderLine pOrderLine) {

        OrderLine orderLine = orderLineRepository.save(pOrderLine);
        OrderLineDTO lineDTO = Util.orderLineDTOMapper(orderLine, new OrderLineDTO());
        return Optional.of(lineDTO);
    }

    @Override
    public List<OrderLineDTO> getCurrentCart(String pUserId) {

        List<OrderLine> lines = orderLineRepository.getCurrentCartByUser(pUserId);

        List<OrderLineDTO> lineDTOs = lines.stream().map(line -> Util.orderLineDTOMapper(line, new OrderLineDTO()))
                .collect(Collectors.toList());

        return lineDTOs;
    }

}

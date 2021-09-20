package io.javabee.cart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.javabee.cart.dao.OrderLineDao;
import io.javabee.cart.documents.OrderLine;
import io.javabee.cart.documents.States;
import io.javabee.cart.dto.CartDTO;
import io.javabee.cart.dto.OrderLineDTO;
import io.javabee.cart.dto.PriceDTO;

@Service
public class CartServiceImpl implements CartService {

    OrderLineDao orderLineDao;

    RestTemplate restTemplate;

    CartServiceImpl(OrderLineDao pOrderLineDao, RestTemplate pRestTemplate) {

        orderLineDao = pOrderLineDao;
        restTemplate = pRestTemplate;
    }

    @Override
    public Optional<CartDTO> getCart(String userId) {

        OrderLineDTO line1 = new OrderLineDTO("1", "1123", "1123", 1L, 33.22, "1123", States.ADDED.toString());
        OrderLineDTO line2 = new OrderLineDTO("1", "1123", "1123", 1L, 22.2, "1123", States.ADDED.name());
        OrderLineDTO line3 = new OrderLineDTO("1", "1123", "1123", 1L, 223.4, "1123", States.ADDED.toString());

        List<OrderLineDTO> orderLines = new ArrayList<>();
        orderLines.add(line1);
        orderLines.add(line2);
        orderLines.add(line3);

        orderLines = orderLineDao.getCurrentCart("jack");

        double cartTotal = orderLines.stream().mapToDouble(line -> line.getPrice()).sum();

        CartDTO cartDTO = new CartDTO(orderLines, cartTotal);

        return Optional.of(cartDTO);
    }

    @Override
    public Optional<CartDTO> addItemToCart(OrderLineDTO lineDTO) {

        String catalogServiceUrl = "http://CATALOG-SERVICE/api/v1/catalog/sku/price/{skuId}";
        Map<String, String> uriParams = new HashMap<>();
        uriParams.put("skuId", lineDTO.getSkuId().toString());

        PriceDTO priceDTO = restTemplate.getForObject(catalogServiceUrl, PriceDTO.class, uriParams);
        OrderLine orderLine = new OrderLine();
        orderLine.setPrice(priceDTO.getSalePrice());
        orderLine.setProductId(lineDTO.getProductId());
        orderLine.setSkuId(lineDTO.getSkuId());
        orderLine.setQuantity(lineDTO.getQuantity());
        orderLine.setUserId(lineDTO.getUserId());
        Optional<OrderLineDTO> optional = orderLineDao.addItemToCart(orderLine);
        CartDTO cartDTO = new CartDTO();
        cartDTO.getOrderLines().add(optional.get());
        return Optional.of(cartDTO);
    }

}

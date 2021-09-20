package io.javabee.cart.helper;

import io.javabee.cart.documents.OrderLine;
import io.javabee.cart.documents.States;
import io.javabee.cart.dto.OrderLineDTO;

public class Util {

    /**
     * 
     * @param pOrderLine
     * @param pOrderLineDTO
     * @return
     */
    public static OrderLineDTO orderLineDTOMapper(OrderLine pOrderLine, OrderLineDTO pOrderLineDTO) {
        pOrderLineDTO.setId(pOrderLine.getId());
        pOrderLineDTO.setPrice(pOrderLine.getPrice());
        pOrderLineDTO.setProductId(pOrderLine.getProductId());
        pOrderLineDTO.setSkuId(pOrderLine.getSkuId());
        pOrderLineDTO.setState("Added");
        pOrderLineDTO.setUserId(pOrderLine.getUserId());
        pOrderLineDTO.setQuantity(pOrderLine.getQuantity());
        return pOrderLineDTO;
    }

    /**
     * 
     * @param pOrderLine
     * @param pOrderLineDTO
     * @return
     */
    public static OrderLine orderLineMapper(OrderLine pOrderLine, OrderLineDTO pOrderLineDTO) {
        pOrderLine.setId(pOrderLineDTO.getId());
        pOrderLine.setPrice(pOrderLineDTO.getPrice());
        pOrderLine.setProductId(pOrderLineDTO.getProductId());
        pOrderLine.setSkuId(pOrderLineDTO.getSkuId());
        pOrderLine.setQuantity(pOrderLineDTO.getQuantity());
        pOrderLine.setState(States.ADDED);
        pOrderLine.setUserId(pOrderLineDTO.getUserId());
        return pOrderLine;
    }

}

package io.javabee.cart.documents;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderLine {

    @MongoId
    String id;

    String productId;

    String skuId;

    long quantity;

    double price;

    String userId;

    Enum<States> state;

    /**
     * 
     * @param productId
     * @param skuId
     * @param quantity
     * @param price
     */
    public OrderLine(String productId, String skuId, long quantity, double price, String userId) {

        this.productId = productId;

        this.skuId = skuId;

        this.quantity = quantity;

        this.price = price;

        this.userId = userId;
    }

}

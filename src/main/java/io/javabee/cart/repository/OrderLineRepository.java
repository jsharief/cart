package io.javabee.cart.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import io.javabee.cart.documents.OrderLine;

@Repository
public interface OrderLineRepository extends MongoRepository<OrderLine, String> {

    @Query("{userId:?0}")
    List<OrderLine> getCurrentCartByUser(String userId);
}

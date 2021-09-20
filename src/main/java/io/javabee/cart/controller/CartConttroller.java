package io.javabee.cart.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabee.cart.dto.CartDTO;
import io.javabee.cart.dto.OrderLineDTO;
import io.javabee.cart.service.CartService;

@RestController

@RequestMapping("/api/v1/cart")
public class CartConttroller {

    CartService cartService;

    CartConttroller(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/current")
    public ResponseEntity<Optional<CartDTO>> getCurrentCart() {
        return new ResponseEntity<>(cartService.getCart("11234"), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Optional<CartDTO>> addLineItem(@RequestBody OrderLineDTO pOrderLineDto) {
        return new ResponseEntity<>(cartService.addItemToCart(pOrderLineDto), HttpStatus.CREATED);
    }

}

package io.javabee.cart.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.javabee.cart.documents.OrderLine;
import io.javabee.cart.documents.States;
import io.javabee.cart.repository.OrderLineRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ItemLoader implements CommandLineRunner {

    @Autowired
    OrderLineRepository orderLineRepository;

    // @Value("${javabee.cart.loadItems}")
    private boolean loadItemLines;

    public boolean isLoadItemLines() {
        return loadItemLines;
    }

    public void setLoadItemLines(boolean loadItemLines) {
        this.loadItemLines = loadItemLines;
    }

    @Override
    public void run(String... args) throws Exception {

        // if (isLoadItemLines())
        // loadItemLines();

        log.info("HEllo here is helll...", isLoadItemLines());

    }

    public void loadItemLines() {

        OrderLine line = new OrderLine("1123", "1123", 2, 23.00, "eventId");
        line.setState(States.ADDED);
        orderLineRepository.save(line);
    }
}

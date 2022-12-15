package bank.cards.controller;

import bank.cards.config.CardsServiceConfig;
import bank.cards.model.Cards;
import bank.cards.model.Customer;
import bank.cards.model.Properties;
import bank.cards.repository.CardsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class CardsController {

    @Autowired
    private CardsRepository cardsRepository;

    @Autowired
    private CardsServiceConfig cardsServiceConfig;

    @PostMapping("/my-cards")
    public List<Cards> getCardDetails(@RequestBody Customer customer) {
        List<Cards> cards = cardsRepository.findByCustomerId(customer.getCustomerId());
        return Objects.nonNull(cards) ? cards : null;
    }

    @GetMapping("/cards/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow =  new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(cardsServiceConfig.getMsg(), cardsServiceConfig.getBuildVersion(),
                cardsServiceConfig.getMailDetails(), cardsServiceConfig.getActiveBranches());
        return ow.writeValueAsString(properties);
    }
}

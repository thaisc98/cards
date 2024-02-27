package bank.cards.service;

import bank.cards.dto.CardsDto;

public interface CardsService {

    /***
     *
     * @param mobileNumber - Mobile number of the Customer
     */
    void createCard(String mobileNumber);

    /***
     *
     * @param mobileNumber -Input mobile number
     * @return Card Details based on a given mobile number
     */
    CardsDto fetchCard(String mobileNumber);

    /***
     *
     * @param cardsDto - CardsDto object
     * @return boolean indicating if the update of the card details is successful or not
     */
    boolean updateCard(CardsDto cardsDto);

    /***
     *
     * @param mobileNumber - Input mobile number
     * @return boolean indicating if delete of the card details is successful or not
     */
    boolean deleteCard(String mobileNumber);
}

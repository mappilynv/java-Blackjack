package com.blackjack;

/**
 * Handle all dealer's activities
 */
public class Dealer extends Person {

    //Create a new dealer
    public Dealer(){
        //Named the dealer "Dealer"
        super.setName("Dealer");
    }

    /**
     * Following the rules of Blackjack, this will print
     * the dealer's first hand with one card face down.
     */
    public void printFirstHand(){
        System.out.println("The dealer's hand looks like this: ");
        System.out.println(super.getHand().getCard(0));
        System.out.println("The second card is face down.");
    }
}

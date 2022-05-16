package com.blackjack;

public class Person {
    private Hand hand;
    //Named the person who can either be a player or a dealer
    private String name;


    //Create a new Person
    public Person(){
        this.hand = new Hand();
        this.name = "";
    }

    public Hand getHand() {
        return this.hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //Print a formatted version of the Person's hand
    public void printHand(){
        System.out.println(this.name + "'s hand looks like this: ");
        System.out.println(this.hand + " Valued at: "+this.hand.calculatedValue());
    }

    /**
     * Player takes a card from the deck
     * @param deck the deck we are drawing from
     * @param discard the deck we discard cards to which will be used when we reshuffle
     */
    public void hit(Deck deck, Deck discard){
        //If there is no cards left in the deck
        if(!deck.hasCards()){
            //reload the deck from the discard pile
            deck.reloadDeckFromDiscard(discard);
        }
        //take a card from the deck
        this.hand.takeCardFromDeck(deck);
        System.out.println(this.name+" gets a card");
        this.printHand();

    }

    /**
     * Check if Person has 21
     * @return True if person has 21
     */
    public boolean hasBlackjack(){
        if(this.getHand().calculatedValue() == 21){
            return true;
        } else{
            return false;
        }
    }



}

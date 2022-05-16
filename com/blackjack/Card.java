package com.blackjack;

public class Card {

    /**
     * One of the four suits for this card (one card)
     */
    private Suit suit;
    /**
     * The number of this card from 2 to 10, Ace, Jack Queen King which will be calculated as a value
     */
    private Rank rank;


    /**
     * Constructor to create a card given a suit and a rank
     * @param suit the suit of the card
     * @param rank the number of the card
     */
    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Return the suit of the card
     * @return the suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Return the rank/number of the card
     * @return the rank/number
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * This is a copy constructor where the card being copied
     * @param card that is copied
     */
    public Card(Card card){
        this.suit = card.getSuit();
        this.rank = card.getRank();
    }

    /**
     *
     * @return the numerical value of the card
     */
    public int getValue(){
        return rank.rankValue;
    }

    @Override
    public String toString() {
        return ("["+rank+" of "+ suit + "] ("+this.getValue()+")");
    }
}

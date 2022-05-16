package com.blackjack;

public enum Suit {
    CLUB("Clubs"),
    DIAMOND("Diamonds"),
    HEART("Hearts"),
    SPADE("Spades");

    //add final so no one case change the value
    final String suitName;

    Suit (String suitName){
        this.suitName = suitName;
    }

    public String toString(){
        return suitName;
    }


}

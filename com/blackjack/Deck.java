package com.blackjack;

import java.util.ArrayList;


/**
 * This class handle a deck of cards
 */
public class Deck {

    //ArrayList is created to hold the deck of class
    private ArrayList<Card> deck;

    //Create an empty deck of cards
    public Deck(){
        deck = new ArrayList<Card>();
    }

    /**
     * This method creates a standard deck of cards
     * @param makeDeck if true, a standard deck card is created
     */
    public Deck(boolean makeDeck){
        deck = new ArrayList<Card>();
        if(makeDeck){
            //go through all the suits
            for(Suit suit: Suit.values()){
                //Go through all the ranks
                for(Rank rank: Rank.values()){
                    //add a new card containing each iteration suit and rank
                    deck.add(new Card(suit, rank));
                }
            }
        }
    }

    /**
     * add card to this deck
     * @param card added to this deck
     */

    public void addCard(Card card){
        deck.add(card);
    }

    //An ArrayList of cards to be added to this deck
    public void addCards(ArrayList<Card> cards){
        deck.addAll(cards);
    }

    //toString method
    public String toString(){
        String output = "";
        for(Card card:deck){
            output += card;
            output += "\n";
        }
        return output;
    }

    //Shuffle the deck
    public void shuffle(){
        ArrayList<Card> shuffled = new ArrayList<Card>();
        //iterate through the size of the deck, so each card can be pulled
        while(deck.size() > 0){
            //Select a random index to pull
            int cardToPull = (int)(Math.random()*(deck.size()-1));
            //Add this random card to the new shuffled deck
            shuffled.add(deck.get(cardToPull));
            //Remove the pulled card from the original deck
            deck.remove(cardToPull);
        }
        deck = shuffled;
    }

    public Card takeCard(){
        //take a copy of the first card from the deck
        Card cardToTake = new Card(deck.get(0));
        //remove the card from the deck
        deck.remove(0);
        //give the card back
        return cardToTake;
    }


    /**
     * Check whether the deck still has cards left
     * @return true if the deck still has cards
     */
    public boolean hasCards(){
        if(deck.size()>0){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Find the number of cards left in the deck
     * @return number of cards left in the deck
     */
    public int cardsLeft(){
        return deck.size();
    }


    /**
     * @return ArrayList containing all the cards in this deck
     */
    public ArrayList<Card> getCards(){
        return deck;
    }

    //Empty out this deck
    public void emptyDeck(){
        deck.clear();
    }

    public void reloadDeckFromDiscard(Deck discard){
        this.addCards(discard.getCards());
        this.shuffle();
        discard.emptyDeck();
        System.out.println("Ran out of cards, creating new deck from discard pile & shuffling deck.");
    }




}

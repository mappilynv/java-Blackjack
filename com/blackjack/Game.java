package com.blackjack;

public class Game {

    private Deck deck, discarded;

    private Dealer dealer;
    private Player player;

    private int wins, losses, pushes;

    public Game(){

        //Create a new deck with 52 cards
        deck = new Deck(true);

        //Create a new empty deck
        discarded = new Deck();

        //Create the People
        dealer = new Dealer();
        player = new Player();

        //Shuffle the deck and start the first round
        deck.shuffle();
        startRound();

    }

    /**
     * This method will handle the logic for each round
     * Start a new round, display score, give out cards,
     * check for Blackjack, ask player what they want to do
     */
    private void startRound(){

        //If this isn't the first round, display the score and put their cards back
        if(wins > 0 || losses > 0 || pushes > 0){
            System.out.println();
            System.out.println("Starting next round.... Wins:"+ wins + " Losses: "+losses+ " Pushes: "+pushes);
            dealer.getHand().discardHandToDeck(discarded);
            player.getHand().discardHandToDeck(discarded);
        }

        //Check to make sure the deck has at least 4 cards left
        if(deck.cardsLeft() < 4){
            //if we are out of cards, reload cards from discarded deck
            deck.reloadDeckFromDiscard(discarded);
        }

        //Give the dealer two cards
        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);

        //Give the player two cards
        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);

        //Print their hands
        dealer.printFirstHand();
        player.printHand();

        //Check if dealer has Blackjack to start
        if(dealer.hasBlackjack()){
            //show the dealer has Blackjack
            dealer.printHand();
            //Check if the player also has Blackjack
            if(player.hasBlackjack()){
                //End the round with a push
                System.out.println("You both have 21 - Push.");
                pushes++;
                //Then, start a new round
                startRound();
            } else {
                System.out.println("Dealer has Blackjack. You lose.");
                dealer.printHand();
                losses++;
                //Player lost, start a new round
                startRound();
            }
        }
        //Check if player has Blackjack to start
        //If we got to this point, we already know the dealer didn't have Blackjack
        if(player.hasBlackjack()){
            System.out.println("You have BlackJack! You win!");
            wins++;
            startRound();
        }
        //Let the player decide what to do next
        //pass the decks in case they decide to hit
        player.makeDecisions(deck, discarded);

        //Check if they busted
        if(player.getHand().calculatedValue() > 21){
            System.out.println("You have gone over 21.");
            //count the losses
            losses++;
            //start the round over
            startRound();
        }

        //Now it's the dealer's turn
        dealer.printHand();
        while(dealer.getHand().calculatedValue() < 17){
            dealer.hit(deck, discarded);
        }

        //Check who wins
        if(dealer.getHand().calculatedValue() > 21){
            System.out.println("Dealer busted!");
            wins++;
        } else if (dealer.getHand().calculatedValue() > player.getHand().calculatedValue()){
            System.out.println("You lost to the dealer!");
            losses++;
        } else if (player.getHand().calculatedValue() > dealer.getHand().calculatedValue()){
            System.out.println("You win!");
            wins++;
        } else {
            System.out.println("Push.");
        }

        //Start a new round
        startRound();


    }

}

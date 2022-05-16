package com.blackjack;

import java.util.Scanner;

public class Player extends Person{

    Scanner scanner = new Scanner(System.in);

    public Player(){
        super.setName("Player");
    }

    /**
     * Allow the player to make decisions
     * @param deck deck we are drawing from when we hit
     * @param discard deck we discard cards to which will be used for reshuffle
     */
    public void makeDecisions(Deck deck, Deck discard){

        int decision = 0;
        //getting a number (int) from input
        boolean getNum = true;

        //While were getting a number
        while(getNum){
            try{
                System.out.println("Would you like to: 1) Hit or 2) Stand");
                decision = scanner.nextInt();
                getNum = false;
            //catch any exception and try again
            } catch (Exception e){
                System.out.println("Invalid");
                scanner.next();
            }
            System.out.println("You selected: "+decision);

            //if they decide to hit
            if(decision == 1){
                //hit the deck using the deck and discard deck
                this.hit(deck, discard);
                //return (exit the method) if they have Blackjack or busted
                if(this.getHand().calculatedValue() > 20){
                    return;
                //if they didn't bust or get 21, allow them to decide to hit or stand
                } else {
                    this.makeDecisions(deck, discard);
                }
                //if they type any number other than 1, we'll assume they are standing
            } else {
                System.out.println("You stand!");
            }
        }

    }



}

package server;

import common.Card;
import common.Face;
import common.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Makes cards for the Chargen server to send.
 *
 * @author Nicholas Widener
 * @author Jameson Burchette
 * @version 10/8/2015
 */
public class CardSource implements ChargenSource {
    /** The number of cards in a deck */
    private static final int DECK_SIZE = 52;
    /** The number of card faces */
    private static final int FACES = 13;
    /** The number of card suits */
    private static final int SUITS = 4;

    /** The cards to send */
    private ArrayList<Card> cards;
    /** Gets the card to send from the cards list */
    private Iterator iterator;
    /** The number of cards this source will send */
    private int itemsToSend;

    /**
     * Constructor; Creates cards, stores and shuffles them, and initializes fields
     *
     * @param itemsToSend The number of cards to send.
     */
    public CardSource(int itemsToSend) {
        cards = new ArrayList<>(DECK_SIZE);
        for (int i = 0; i < FACES; i++) {
            Face face = Face.values()[i];
            for (int j = 0; j < SUITS; j++) {
                Suit suit = Suit.values()[j];
                cards.add(new Card(face, suit));
            }
        }
        Collections.shuffle(cards);
        iterator = cards.iterator();
        this.itemsToSend = itemsToSend;
    }

    /**
     * Gets the next card to send.
     *
     * @return The next card to send
     */
    @Override
    public Card next() {
        Card card;
        if (iterator.hasNext()) {
            card = (Card)iterator.next();
            itemsToSend--;
        }
        else {
            iterator = cards.iterator();
            card = next();
        }
        return card;
    }

    /**
     * Gets the number of cards left to send
     *
     * @return The number of cards left to send
     */
    @Override
    public int itemsToSend() {
        return itemsToSend;
    }
}

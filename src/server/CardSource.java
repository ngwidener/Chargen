package server;

import common.Card;
import common.Face;
import common.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by Jameson on 10/25/2015.
 */
public class CardSource implements ChargenSource {
    private static final int DECK_SIZE = 52;

    private ArrayList<Card> cards;
    private Iterator iterator;
    private int itemsToSend;

    public CardSource(int itemsToSend) {
        cards = new ArrayList<>(DECK_SIZE);
        for (int i = 0; i < 13; i++) {
            Face face = Face.values()[i];
            for (int j = 0; j < 4; j++) {
                Suit suit = Suit.values()[j];
                cards.add(new Card(face, suit));
            }
        }
        Collections.shuffle(cards);
        iterator = cards.iterator();
        this.itemsToSend = itemsToSend;
    }

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

    @Override
    public int itemsToSend() {
        return itemsToSend;
    }
}

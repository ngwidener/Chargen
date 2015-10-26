package server;

import common.Card;

/**
 * Created by Jameson on 10/25/2015.
 */
public class CardSource implements ChargenSource {
    private int itemsToSend;

    @Override
    public Card next() {
        return null;
    }

    @Override
    public int itemsToSend() {
        return itemsToSend;
    }
}

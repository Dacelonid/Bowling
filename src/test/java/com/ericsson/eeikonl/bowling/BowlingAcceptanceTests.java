/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2014
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package com.ericsson.eeikonl.bowling;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BowlingAcceptanceTests {
    BowlingGame game;

    @Before
    public void setup() {
        game = new BowlingGame();
    }

    @Test
    public void scoreGame_noSparesOrStrikes() throws Exception {
        rollScore(new int[] { 9, 0, 3, 5, 6, 1, 3, 6, 8, 1, 5, 3, 2, 5, 8, 0, 7, 1, 8, 1 });
        assertEquals(82, game.calculateScore());
    }

    @Test
    public void scoreGame_withSparesNoStrikes() throws Exception {
        rollScore(new int[] { 9, 0, 3, 7, 6, 1, 3, 7, 8, 1, 5, 5, 0, 10, 8, 0, 7, 3, 8, 2, 8 });
        assertEquals(131, game.calculateScore());
    }

    @Test
    public void scoreGame_withSparesAndStrikes() throws Exception {
        rollScore(new int[] { 10, 3, 7, 6, 1, 10, 10, 10, 2, 8, 9, 0, 7, 3, 10, 10, 10 });
        assertEquals(193, game.calculateScore());
    }

    @Test
    public void scoreGame_perfectGame() throws Exception {
        rollScore(new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 });

        assertEquals(300, game.calculateScore());
    }

    private void rollScore(final int[] score) {
        for (final int pins : score) {
            game.roll(pins);
        }
    }
}

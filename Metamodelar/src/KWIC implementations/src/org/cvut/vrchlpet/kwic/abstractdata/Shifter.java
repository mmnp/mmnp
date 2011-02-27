/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.kwic.abstractdata;

import java.util.ArrayList;

/**
 *
 * @author Vrchli
 */
public class Shifter {

    private Tokenizer tokenizer;

    /*
     *
     * vstup
     *   _______
     * 0|a,b,c  |
     * 1|d,e,f,g|
     *   -------
     *
     * vystup
     *
     *  
     *  ___________
     * |           |
     * | 0_____    |
     * | |0,1,2|   | <- ArryList<Integer> |
     * | |1,2,0|   | <- ArryList<Integer> | <- ArrayList<ArrayList<Integer>> | <- odpovida puvodnimu 1. radku
     * | |2,0,1|   | <- ArryList<Integer> |                                  |
     * |  -----    |                                                         |
     * |           |                                                         | <- ArrayList<ArrayList<ArrayList<Integer>>>
     * | 1_______  |                                                         |
     * | |0,1,2,3| | <- ArryList<Integer> |                                  |
     * | |1,2,3,0| | <- ArryList<Integer> | <- ArrayList<ArrayList<Integer>> | <- odpovida puvodnimu 2. radku
     * | |2,3,0,1| | <- ArryList<Integer> |
     * | |3,0,1,2| | <- ArryList<Integer> |
     * | --------  |
     *  -----------
    */

    // 2 pole, tokens jsou originalni radky slozene ze slov a shiftedTokenIndexes jsou indexi, ktere mapuji jednotlive shifty
    // takze ve skutecnosti neprovadime presuny na originalnich datech ale pouze nad polem indexu....
    private ArrayList<ArrayList<ArrayList<Integer>>> shiftedTokenIndexes;
    private ArrayList<ArrayList<String>> tokens;

    public Shifter(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
        tokens = this.tokenizer.getTokens();

        // priprava prazdneho pole indexu
        shiftedTokenIndexes = new ArrayList<ArrayList<ArrayList<Integer>>>(tokens.size());
        for ( int i = 0; i < tokens.size(); i++) {
            shiftedTokenIndexes.add(new ArrayList<ArrayList<Integer>>(tokens.get(i).size()));
            for ( int e = 0; e < tokens.get(i).size(); e++) {

                shiftedTokenIndexes.get(i).add(new ArrayList<Integer>(tokens.get(e).size()));
            }
        }
    }

    public ArrayList<ArrayList<ArrayList<Integer>>> getIndexes() {
        return this.shiftedTokenIndexes;
    }

    public ArrayList<ArrayList<String>> getTokens() {
        return this.tokens;
    }

    public void doShifts() {
        for ( ArrayList<ArrayList<Integer>> aai : shiftedTokenIndexes) {
            for ( int i = 0; i < aai.size(); i++) {
                for ( int e = 0; e < aai.size(); e++) {
                   int index = (e + i) % aai.size();
                   aai.get(i).add( index );
                }
            }
        }

    }

    public String getOriginalText() {
        String output = "";
        for ( int e = 0; e < getTokens().size(); e++) {
            if ( e != 0)
                output += '\n';
            for ( int i = 0; i < getTokens().get(e).size(); i++) {
                if ( i != 0)
                    output += " ";
                output += getTokens().get(e).get(i);
            }
        }
        return output;
    }

    public String getShiftedText() {
        String output = "";
        for ( int j = 0; j < shiftedTokenIndexes.size(); j++) {
            for ( int i = 0; i < shiftedTokenIndexes.get(j).size(); i++) {
                if ( j != 0 || i != 0)
                    output += '\n';
                for ( int e = 0; e <shiftedTokenIndexes.get(j).get(i).size(); e++) {
                    int index = (e + i) % shiftedTokenIndexes.get(j).size();
                    if ( e != 0)
                        output += " ";

                    output += tokens.get(j).get(index);
                }
            }
        }

        return output;
    }
}

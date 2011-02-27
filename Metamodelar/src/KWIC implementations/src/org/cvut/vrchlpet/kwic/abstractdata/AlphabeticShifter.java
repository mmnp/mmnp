/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.kwic.abstractdata;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Vrchli
 */
public class AlphabeticShifter {

    private Shifter shifter;
    private ArrayList<String> orderedShiftedTest;

    public AlphabeticShifter(Shifter shifter) {
        this.shifter = shifter;
        orderedShiftedTest = new ArrayList<String>();
    }




    public void doOrdering() {
        ArrayList<ArrayList<ArrayList<Integer>>> shiftedTokenIndexes = this.shifter.getIndexes();
        ArrayList<ArrayList<String>> tokens = this.shifter.getTokens();

        String line = "";
        for ( int j = 0; j < shiftedTokenIndexes.size(); j++) {
            for ( int i = 0; i < shiftedTokenIndexes.get(j).size(); i++) {

                for ( int e = 0; e <shiftedTokenIndexes.get(j).get(i).size(); e++) {
                   if ( e != 0)
                       line += " ";
                   int index = (e + i) % shiftedTokenIndexes.get(j).size();
                   line += tokens.get(j).get(index);
                }
                orderedShiftedTest.add(line);
                line = "";
            }
        }

        String [] ar = new String [orderedShiftedTest.size()];

        for ( int i = 0; i < ar.length; i++) {
            ar[i] = orderedShiftedTest.get(i);
        }
        
        MyBubbleSort.sortStringBubble(ar);
        
        orderedShiftedTest.clear();
        orderedShiftedTest.addAll(Arrays.asList(ar));
    }

    public String getOrderedShiftedText() {
        String output = "";
        for ( int i = 0; i < orderedShiftedTest.size(); i++) {
            if ( i != 0)
                output += '\n';
            output += orderedShiftedTest.get(i);
        }
        return output;
    }

}

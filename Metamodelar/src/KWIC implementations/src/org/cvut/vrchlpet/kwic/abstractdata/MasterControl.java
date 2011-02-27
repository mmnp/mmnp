/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.kwic.abstractdata;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author Vrchli
 */
public class MasterControl {






    public void start() {
        Tokenizer tokenizer = new Tokenizer();

        Input input = new Input(tokenizer);

        try {
            input.ReadData();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Spatna data!");
            System.exit(0);
        }



        System.out.println(" ============================ nactena data ============================");
        System.out.println(input.getStringOfFile());

        Shifter shifter = new Shifter(tokenizer);
        shifter.doShifts();

        System.out.println(" ============================ upravena data ============================");
        System.out.println(shifter.getOriginalText());

        System.out.println(" ============================ data po prehozech ============================");
        System.out.println(shifter.getShiftedText());

        System.out.println(" ============================ serazeni ============================");
        AlphabeticShifter as = new AlphabeticShifter(shifter);
        as.doOrdering();
        System.out.println(as.getOrderedShiftedText());
    }

}

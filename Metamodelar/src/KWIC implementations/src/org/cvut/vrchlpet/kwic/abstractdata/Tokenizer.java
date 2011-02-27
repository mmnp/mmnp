/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.kwic.abstractdata;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vrchli
 */
public class Tokenizer {

    private File file;

    

    public void setData(File file) {
        this.file = file;
    }



    public ArrayList<ArrayList<String>> getTokens() {

        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException ex) {
            /* nemelo by nikdy nastat v kontextu teto aplikace (MasterControle nikdy nepusti program dal, pokud Tokenizer neobdrzi spravna data...)
                chyby OS a HW nepocitam :-)
             */
            ex.printStackTrace();
        }

        

        int c;
        String word = "";

        /* vnitrni arrylist predstavuje slova v radku, vnejsi pak jednotlive radky */
        ArrayList<ArrayList<String>> tokens = new ArrayList<ArrayList<String>>();

        ArrayList<String> tokensInLine = new ArrayList<String>();

        /*
            algoritmus ignoruje mezery...
        */
        try {
            x:while (true) {
                c = fr.read();
                switch (c) {
                    case ' ':
                        if ( word.equals(""))
                            continue x;
                        
                        tokensInLine.add(word);
                        word = "";
                        continue x;
                    case '\n':
                        continue x;
                    case -1:
                    case '\r':
                        if ( !word.equals("")) {
                            tokensInLine.add(word);
                            word = "";
                            tokens.add(tokensInLine);
                        } else {
                            if ( !tokensInLine.isEmpty()) {
                                tokens.add(tokensInLine);
                            }
                        }
                        
                        if ( c == -1)
                            break x;

                        tokensInLine = new ArrayList<String>();
                        continue x;
                    default:
                        word += (char)c;
                        break;
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(Tokenizer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tokens;

    }

}

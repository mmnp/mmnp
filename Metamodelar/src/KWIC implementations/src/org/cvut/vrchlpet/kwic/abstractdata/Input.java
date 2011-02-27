/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.kwic.abstractdata;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Vrchli
 */
public class Input {

    private Tokenizer tokenizer;
    private File file = null;

    public Input(Tokenizer tokenizer){
        this.tokenizer = tokenizer;
    }


    public String getStringOfFile() {
        if ( file == null)
            return null;

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
        String s = "";
        try {
            while ((c = fr.read()) != -1) {
                s += (char)c;
            }
        } catch (IOException ex) {
            Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
        }

        return s;
    }

    public void ReadData() throws IOException{

        JFileChooser fc = new JFileChooser(".");
        int choice = fc.showOpenDialog(null);

        if (choice == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
        }

        if ( file == null || !file.isFile() )
            throw new IOException();


        tokenizer.setData(file);
    }
}

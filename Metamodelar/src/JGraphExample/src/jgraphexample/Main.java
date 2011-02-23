/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jgraphexample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vrchli
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        String path = "D://test.txt";
        int offset = 4;



        doIt(path, offset);
    }




    public static void doIt(String path, int offset) {

        File fileIn = new File(path);
        File fileOut = new File(path + ".out");


        try {
            BufferedReader br = new BufferedReader(new FileReader(fileIn));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut));

            String line;
            while ((line = br.readLine()) != null) {
                line = line.substring(offset, line.length());
                bw.write(line + '\n');
            }

            bw.flush();
            bw.close();
            br.close();

            System.out.println("konvertion done");

        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

}



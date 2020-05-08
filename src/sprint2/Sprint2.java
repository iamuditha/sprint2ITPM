/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprint2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author uditha
 */
public class Sprint2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Read the file
        BufferedReader bufferReader = null;
        try {
            bufferReader = new BufferedReader(new FileReader("code.txt"));

            //Read the File
            String contentLine = bufferReader.readLine().trim();
            while (contentLine != null) {
                //print the line
                System.out.println(contentLine);
                //System.out.println( new size().keywordCount(contentLine));
                //System.out.println(new size().operatorCount(contentLine));
                //System.out.println(new size().numericalValueCount(contentLine));
                System.out.println(new size().stringLiteralsCount(contentLine));

                contentLine = bufferReader.readLine();

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sprint2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sprint2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

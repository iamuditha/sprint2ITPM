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

        variable v = new variable();

        //Read the file
        BufferedReader bufferReader = null;
        try {
            bufferReader = new BufferedReader(new FileReader("code.txt"));

            //Read the File
            String contentLine = bufferReader.readLine().trim();
            while (contentLine != null && !contentLine.trim().startsWith("import") ) {

                if (contentLine.trim().length() != 0) {
                    System.out.println(contentLine);
                    contentLine = contentLine.trim();

                }
                if (contentLine.contains("//")) {
                    System.out.println(contentLine.substring(0, contentLine.indexOf("//")));
                    contentLine = contentLine.substring(0, contentLine.indexOf("//"));

                }               
                //print the line
                //System.out.println( new size().keywordCount(contentLine));
                System.out.println(new size().operatorCount(contentLine));
                //System.out.println(new size().numericalValueCount(contentLine));
                //System.out.println(new size().stringLiteralsCount(contentLine));
                //System.out.println(new method().methodCount(contentLine));
                //System.out.println(v.variableCount(contentLine));
                //System.out.println(new size().identifierCount(contentLine));

                contentLine = bufferReader.readLine();

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sprint2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sprint2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprint2;

import static java.lang.Thread.sleep;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author uditha
 */
public class size {

    //List of Operators
    List<String> operators = Arrays.asList("+", "-", "*", "/", "%", "++", "--",
            "==", "!=", ">", "<", ">=", "<=",
            "&&", "||", "!", "&", "|", "^", ":",
            "|", "^", "~", "<<", ">>", ">>>", "<<<",
            ",", "->", ".", "::",
            "+=", "-=", "*=", "/=", "=", ">>>=", "|=", "&=", "%=", "<<=", ">>=", "^=");

    //List of the keywords in C++
    List<String> ckeywords = Arrays.asList("auto", "struct",
            "break", "enum", "register", "typedef",
            "extern", "return", "union", "const", "unsigned",
            "continue", "signed", "void",
            "default", "goto", "sizeof", "volatile", "static", "asm", "dynamic_cast", "namespace", "reinterpret_cast",
            "explicit", "new", "static_cast", "catch", "false", "operator", "template",
            "class", "friend", "private", "this", "const_cast", "inline", "public", "throw",
            "delete", "mutable", "protected", "true", "try", "typeid", "typename", "using",
            "using", "virtual", "char_t");

    //List of the keywords
    List<String> keywords = Arrays.asList("abstract", "assert",
            "break", "catch", "class", "const",
            "continue", "default", "extends", "false",
            "final", "finally", "goto", "implements",
            "import", "instanceof", "interface", "native",
            "new", "null", "package", "private", "protected", "public",
            "return", "static", "strictfp", "super",
            "synchronized", "this", "throw", "throws", "transient", "true",
            "try", "void", "volatile");

    //List of data types
    List<String> dataTypes = Arrays.asList("byte", "short", "int", "long", "float", "double", "boolean", "char", "String");

    //List of controll xtructures
    List<String> controlStructures = Arrays.asList("for", "while", "do-while", "if", "switch", "case");

    //List of other non identifies
    List<String> other = Arrays.asList("main");

    public int keywordCount(String line) {

        String word = ""; //initial word
        int nwk = 0; //keywordCount
        int charNo = 0; //character no of the line

        while (line.length() > charNo) {

            if (Character.isLetter(line.charAt(charNo))) {
                word = word + line.charAt(charNo);
            } else {
                //System.out.println(word);
                if (keywords.contains(word)) {
                    //System.out.println(word + " ");
                    nwk++;
                }

                word = "";

            }

            charNo++;
        }

        return nwk;

    }

    public int operatorCount(String line) throws InterruptedException {

        String operator = ""; //initial word
        int nop = 0; //operatorCount
        int charNo = 0; //character no of the line
        int count = 0;
        while (line.length() > charNo) {

            //System.out.println("char  "+ line.charAt(charNo));
            if ((line.charAt(charNo)) == '\"') {
                count = count + 1;
                if (count%2 == 0){
                    operator = "";
                }
                //System.out.println("1count "+ count);

            }

            if (operators.contains(Character.toString(line.charAt(charNo)))) {
                operator = operator + Character.toString(line.charAt(charNo));
                //System.out.println("operator " + operator);
                //System.out.println("2count " + count);
            } else {
                if (!"".equals(operator)) {
                    //  System.out.println(operator);
                    operator = "";
                    if (count % 2 == 0) {
                        //System.out.println("3count " + count);

                        nop++;
                    }

                }

            }
            charNo++;

        }

        if (!"".equals(operator)) {
            nop++;
            operator = "";
        }
        return nop;

    }

    public int numericalValueCount(String line) {

        String numericalValue = ""; //initial word
        int nnv = 0; //nemeric values Count
        int charNo = 0; //character no of the line

        while (line.length() > charNo) {

            if (Character.isDigit(line.charAt(charNo))) {
                numericalValue = numericalValue + Character.toString(line.charAt(charNo));
                //System.out.println(operator);
            } else {
                if (!"".equals(numericalValue)) {
                    nnv++;
                    numericalValue = "";
                }
            }
            charNo++;
        }

        return nnv;

    }

    public int stringLiteralsCount(String line) {

        String numericalValue = ""; //initial value
        int nnsl = 0; // string literal Count
        int charNo = 0; //character no of the line

        while (line.length() > charNo) {

            if (line.charAt(charNo) == '"') {
                nnsl++;
                //System.out.println(operator);
            }
            charNo++;
        }
        return nnsl / 2;

    }

    public int identifierCount(String line) {

        String word = ""; //initial word
        int nid = 0; //identifier Count
        int charNo = 0; //character no of the line
        int commaCount = 0;

        while (line.length() > charNo) {

            if (line.charAt(charNo) == '"') {
                commaCount++;
            }
            if (commaCount % 2 == 0) {
                if (Character.isLetter(line.charAt(charNo))) {
                    word = word + line.charAt(charNo);
                } else {
                    //System.out.println(word);
                    if (word != "" && !dataTypes.contains(word) && !controlStructures.contains(word) && !keywords.contains(word) && !other.contains(word)) {
                        //System.out.println(word + " ******** ");
                        nid++;
                    }

                    word = "";

                }
            }

            charNo++;
        }

        return nid;

    }

}

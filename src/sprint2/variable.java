/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprint2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author uditha
 */
public class variable {

    private static Pattern variable = Pattern.compile("\"[^\"]*\"|((?=_[a-z_0-9]|[a-z])([a-z_0-9]|[a-z0-9\\[\\]])+(?=\\s*=))");

    private static final Pattern method = Pattern.compile("(public|protected|private|static|\\s) +[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;])");

    //List of data types
    List<String> dataTypes = Arrays.asList("byte", "short", "int", "long", "float", "double", "boolean", "char", "String");

    //List of controll xtructures
    List<String> controlStructures = Arrays.asList("for", "while", "do-while", "if", "switch", "case");

    List<String> other = Arrays.asList("{");

    boolean isInsideLoop = false;
    boolean isFirstTime = true;
    int open = 0;
    int helper = 0;
    int scope = 0;

    public List<Object> variableCount(String line) {
        String word = ""; //initial word
        int npdtv = 0; //primitive variables
        int charNo = 0; //character no of the line
        int wvs = 0; //weight of scope

        while (!isInsideLoop && line.length() > charNo) {

            if (line.charAt(charNo) == '{') {
                scope = scope + 1;
               // System.out.println(scope + " ******");
            }
            if (line.charAt(charNo) == '}') {
                scope = scope - 1;
                //System.out.println(scope + " ****");

            }
            if (!method.matcher(line).find()) {
                if (Character.isLetter(line.charAt(charNo))) {
                    word = word + line.charAt(charNo);
                } else {
                    if (controlStructures.contains(word)) {
                        isInsideLoop = true;
                        break;
                    }
                    //System.out.println(word);
                    if (dataTypes.contains(word) && !isInsideLoop) {
                        //System.out.println(word + "********************************************************** ");
                        if (scope == 1) {
                            //System.out.println("global "+ scope);
                            wvs = 2;
                        } else {
                            //System.out.println("local " + scope);
                            wvs = 1;
                        }
                        npdtv++;
                    }

                    word = "";

                }
            }

            charNo++;
        }
        while (isInsideLoop && line.length() > charNo) {
            if (line.charAt(charNo) == '{') {
                open = open + 1;
                scope = scope + 1;
                isFirstTime = false;
            }
            if (line.charAt(charNo) == '}') {
                open = open -1 ;
                scope = scope - 1;
            }
            if (open == 0 && !isFirstTime) {
                isInsideLoop = false;
                isFirstTime = true;
            }
            charNo++;
        }
        return Arrays.asList(wvs, npdtv);

    }

}

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package sprint2;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
///**
// *
// * @author uditha
// */
//public class method {
//
//    private static final Pattern param = Pattern.compile("\\((.*?)\\)");
//
//    private static final Pattern method = Pattern.compile("(public|protected|private|static|\\s) +[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;])");
//    List<String> pDataTypes = Arrays.asList("boolean", "byte", "char", "short", "int", "long", "float", "double");
//
//    public int methodCount(String line) {
//        Matcher matcher = method.matcher(line);
//
//        int pData = 0;
//        int cData = 0;
//        int returnType = 0;
//        boolean isReturnTypeFound = false;
//
//        if (matcher.find()) {
//            System.out.println("method found");
//            Matcher p = param.matcher(line);
//            while (p.find()) {
//
//                if (line.contains("void")) {
//                    returnType = 0;
//                } else {
//                    for (int pType = 0; pType < pDataTypes.size(); pType++) {
//                        if (line.substring(0, line.indexOf("(")).contains(pDataTypes.get(pType))) {
////                              System.out.println(contentLine.substring(0, contentLine.indexOf("(")));
//                            isReturnTypeFound = true;
//                            returnType = 1;
//                        }
//                    }
//                    if (!isReturnTypeFound) {
//                        returnType = 2;
//                    }
//                }
//
//                System.out.print("returnType : " + returnType);
//
//                String params = p.group(1);
//                List<String> paramList = Arrays.asList(params.split(","));
////                    System.out.println(paramList.get(0));
////                    System.out.println(paramList.size());
//
//                for (int pCount = 0; pCount < paramList.size(); pCount++) {
//                    for (int pType = 0; pType < pDataTypes.size(); pType++) {
//                        if (paramList.get(pCount).trim().startsWith(pDataTypes.get(pType))) {
//                            System.out.print(pDataTypes.get(pType));
//                            pData++;
//                            break;
//                        }
//                    }
//                }
//                if (paramList.get(0).length() != 0) {
//                    cData = paramList.size() - pData;
//                } else {
//                    cData = paramList.size() - pData - 1;
//                }
//
//            }
//            System.out.print("PDataCount : " + pData + " ");
//            System.out.print("CDataCount : " + cData + " ");
//
//        }
//        return 0;
//    }
//}

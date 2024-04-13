/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author haiyenng4
 */
public class Validate {

    private static String REGEX_CHAR = "^[a-zA-Z\\p{L}\\s]+$";
    private static String REGEX_NUMBER = "^[1-9]\\d*$";
    private static String REGEX_FLOAT = "^\\d+(\\.\\d+)?$";

    public static boolean checkEmpty(String str) {
        return str.trim().isEmpty();
    }

    public static boolean checkChar(String str) {
        return str.trim().matches(REGEX_CHAR);
    }

    public static boolean checkNumber(String str) {
        return str.trim().matches(REGEX_NUMBER);
    }

    public static boolean checkFloat(String str) {
        return str.trim().matches(REGEX_FLOAT);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson7_udp;

/**
 *
 * @author mam
 */
public class StrUtil {

    public StrUtil() {
    }
    public static String reverse(String _str){
        String _temp = "";
        for(int i = _str.length() - 1; i>=0; i--)
            _temp +=_str.charAt(i);
//        return new StringBuilder(_str).reverse().toString();
        return _temp;
    }
    
}

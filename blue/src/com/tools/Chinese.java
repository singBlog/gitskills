package com.tools;

import java.io.UnsupportedEncodingException;

//中文可乱码处理
public class Chinese {
    public  static String  toChinese(String strvalue) {
           try {
               if (strvalue == null) {
                   return "";
               } else {
                   strvalue =  new String(strvalue.getBytes("ISO-8859-1"), "utf-8");
                   return strvalue;
               }
           } catch (Exception e) {
               return "";
           }
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
	}
}

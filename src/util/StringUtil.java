package util;

public class StringUtil {

	public static String firstUpCase(String str) {
		String result=str.substring(0,1).toUpperCase()+str.substring(1,str.length());
		return result;
	}
	
	public static String firstLowerCase(String str){
		String result=str.substring(0,1).toLowerCase()+str.substring(1,str.length());
		return result;
	}
	
	public static boolean strIsNullOrEmpty(String s) {
	    return (null == s || s.trim().length() < 1 || "null".equals(s));
    }
}

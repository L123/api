package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test002 {

	public static void main(String[] args) {
		test002 t = new test002();
		// TODO Auto-generated method stub
		int n = 1;
		String m = "ceshi";
		
		   System.out.println(m.getClass().getSimpleName());
		    //方法二：判断类型
		    //System.out.println(n instanceof String);
		   
t.isNumeric("1");
	}

	
	 public static boolean isNumeric(Object str)   
	 {   
		 
		 if(str instanceof String){
			 System.out.println("zifu");
		 }
		 else{
			 System.out.println(1);
		 }
		return false;
	 }      
}

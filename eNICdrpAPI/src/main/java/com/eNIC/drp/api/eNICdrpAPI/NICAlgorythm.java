package com.eNIC.drp.api.eNICdrpAPI;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NICAlgorythm {
	
	public static void main() throws Exception{
		String dobtext = "1997-01-23";  
	    Date dateofbirth=new SimpleDateFormat("YYYY-mm-dd").parse(dobtext); 
		
		String firstfourarr[] = dobtext.split("-");
		String firstfour = firstfourarr[0];
		System.out.println(firstfour);
		
		String secondthree = "";
		String month = firstfourarr[1];
		System.out.println(month);
		String day = firstfourarr[2];
		System.out.println(day);
		
		
		String lastfive="";
	}
	
}

package com.eNIC.drp.api.eNICdrpAPI.enicservices;

public class NICAlgo {
	
    

	public static void main(String []args) {
		
	}
	
	public static String NICAlgoMethod(String dobtext, String gender) {
		int dateno = -1;
		String splitdob[] = dobtext.split("-");
		
		String yeartext = splitdob[0];
		String monthtext = splitdob[1].trim();
		System.out.println(monthtext);
		int dayno = Integer.parseInt(splitdob[2]);
	 	
		NICAlgo nicAlgo = new NICAlgo();
		
		switch(monthtext) {
          case "01":
            dateno = dayno;
            break;
          case "02":
            dateno = 31+dayno;
            break;
          case "03":
            dateno = 60+dayno;
            break;
          case "04":
            dateno = 91+dayno;
            break;
          case "05":
            dateno = 121+dayno;
            break;
          case "06":
            dateno = 152+dayno;
            break;
          case "07":
            dateno = 182+dayno;
            break;
          case "08":
            dateno = 213+dayno;
            break;
          case "09":
            dateno = 244+dayno;
            break;
          case "10":
            dateno = 274+dayno;
            break;
          case "11":
            dateno = 305+dayno;
            break;
          case "12":
            dateno = 335+dayno;
            break;
          default:
            dateno = 900;
        }
        
        if(dateno != -1){ 
        	switch(gender) {
            case "female":
              dateno = dateno + 500 ;
              break;
            case "male":
              dateno = dateno;
              break;              
          }
          
          return yeartext.concat(String.valueOf(dateno));
        } else{
        	System.out.println("ERROR");            
        }
        return String.valueOf(dateno);
	}
	
}

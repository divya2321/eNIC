package com.eNIC.drp.api.eNICdrpAPI.enicservices;

import java.util.List;

import com.eNIC.drp.api.eNICdrpAPI.enicentity.DRPCommonEntity;
import com.eNIC.drp.api.eNICdrpAPI.enicentity.GeneralDetail;
import com.eNIC.drp.api.eNICdrpAPI.enicrepository.GeneralDetailRepository;
import com.eNIC.drp.api.eNICdrpAPI.exception.ResourceNotFoundException;

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
        	switch(gender.toLowerCase()) {
            case "female":
              dateno = dateno + 500 ;
              break;
            case "male":
              dateno = dateno+0;
              break;              
          }
          
          return yeartext.concat(String.valueOf(dateno));
        } else{
        	System.out.println("ERROR");            
        }
        return String.valueOf(dateno);
	}
	
	public static String generateFullNicNo(GeneralDetailRepository generalDetailRepository, DRPCommonEntity drpCommonEntity, String firstHalf) {
		
		List<GeneralDetail> dobrecord = generalDetailRepository.findByDob(drpCommonEntity.getDob());
		
		int recno = dobrecord.size()+1; 
		String nicNo= null;
		
		if (recno!=0) {			
			String recnotext = String.valueOf(recno);
			
			int recnolength = String.valueOf(recno).length();
			
			if (recnolength<100000) {
				switch(recnolength) {  
				case 1:
					nicNo = firstHalf+"0000"+recnotext;
		            break;
		        case 2:
		        	nicNo = firstHalf+"000"+recnotext;
		            break;
		        case 3:
		        	nicNo = firstHalf+"00"+recnotext;
		            break;
		        case 4:
		        	nicNo = firstHalf+"0"+recnotext;
		            break;
		        default:
		        	nicNo = firstHalf+recnotext;
				}
				System.out.println(nicNo);
			} else {
				throw new ResourceNotFoundException("Available Number Found");
			}			
			}else {
			nicNo = firstHalf+"00001";
		}
		
		return nicNo;
		
	}
	
}

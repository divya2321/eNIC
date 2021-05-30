package com.eNIC.FinancialInstitution.eNICFinancialInstitution.controller;



import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;

import com.eNIC.FinancialInstitution.eNICFinancialInstitution.entity.CommonGeneralDetail;
import com.eNIC.FinancialInstitution.eNICFinancialInstitution.service.FinancialService;

@Controller
@RequestMapping("/finance")
public class FinancialController {

	@Autowired
	private FinancialService financialService;
	
	
	
	@GetMapping("/view/person")
	public String viewPesonDetails(Model model) {
		return "view_person";
	}
	
	@GetMapping("/view/person/search")
	public String searchPesonDetails(@RequestParam("nic")String nic, Model model) throws RestClientException, URISyntaxException {
		
		CommonGeneralDetail person = financialService.searchGeneralDetials(nic);
	
		model.addAttribute("person", person);
	
		return "view_person";
	
	}
	
	
	
	@GetMapping("/fill/form")
	public String fillForm(Model model) {
		return "search_person";
	}
	
	
	@GetMapping("/fill/form/process")
	public String fillFormProcess(@RequestParam("nic1")String nic1,@RequestParam("nic2")String nic2, Model model) throws RestClientException, URISyntaxException {
		
		CommonGeneralDetail person1 = financialService.searchGeneralDetials(nic1);
		CommonGeneralDetail person2 = financialService.searchGeneralDetials(nic2);
	   
		
		
		 try {
	            PDDocument pDDocument = PDDocument.load(new File("src/main/resources/static/Home-loans-en.pdf"));
	            PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();
	            
	            PDField field = pDAcroForm.getField("name1");
	            field.setValue(person1.getName());
	            
	            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    	    String dob = formatter.format(person1.getDob());  
	    	    String dobSplit[] = dob.split("/");
	    	    
	    	    for (int i = 0; i < dobSplit[0].length(); i++) {
	    	    	 int ii = i+1;
	    	    	 field = pDAcroForm.getField("date1_"+ii);
		            field.setValue(String.valueOf(dobSplit[0].charAt(i)) );
	            }
	    	    
	    	    for (int i = 0; i < dobSplit[1].length(); i++) {
	    	    	int ii = i+1;
	    	    	 field = pDAcroForm.getField("month1_"+ii);
		            field.setValue(String.valueOf(dobSplit[1].charAt(i)) );
	            }
	    	    
	    	    for (int i = 0; i < dobSplit[2].length(); i++) {
	    	    	int ii = i+1;
	    	    	 field = pDAcroForm.getField("year1_"+ii);
		            field.setValue(String.valueOf(dobSplit[2].charAt(i)) );
	            }
	    	    
	            
	            field = pDAcroForm.getField("permanent_address_first1");
	            field.setValue(person1.getAddressPermanentNo());
	            
	            field = pDAcroForm.getField("permanent_address_second1");
	            field.setValue(person1.getAddressPermanentStreet1()+" "+person1.getAddressPermanentStreet2()+" "+person1.getAddressPermanentCity());
	            
	            field = pDAcroForm.getField("residential_address_first1");
	            field.setValue(person1.getAddressResidentNo());
	            
	            field = pDAcroForm.getField("residential_address_second1");
	            field.setValue(person1.getAddressResidentStreet1()+" "+person1.getAddressResidentStreet2()+" "+person1.getAddressResidentCity());
	            
	            field = pDAcroForm.getField("mobile1");
	            field.setValue(person1.getMobileNo());
	            
	            field = pDAcroForm.getField("residence1");
	            field.setValue(person1.getResidentNo());
	            
	            field = pDAcroForm.getField("email1");
	            field.setValue(person1.getEmailAddress());
	            
	            
	            for (int i = 0; i <person1.getNicNo().length(); i++) {
	            	int ii = i+1;
	    	    	 field = pDAcroForm.getField("nic1_"+ii);
		            field.setValue(String.valueOf(person1.getNicNo().charAt(i)) );
	            }
	            
	           
	            
	            
	            
	            
	            field = pDAcroForm.getField("name2");
	            field.setValue(person2.getName());
	            
	            SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");  
	    	    String dob1 = formatter1.format(person2.getDob());  
	    	    String dobSplit1[] = dob1.split("/");
	    	    
	    	    for (int i = 0; i < dobSplit1[0].length(); i++) {
	    	    	 int ii = i+1;
	    	    	 field = pDAcroForm.getField("date2_"+ii);
		            field.setValue(String.valueOf(dobSplit1[0].charAt(i)) );
	            }
	    	    
	    	    for (int i = 0; i < dobSplit1[1].length(); i++) {
	    	    	int ii = i+1;
	    	    	 field = pDAcroForm.getField("month2_"+ii);
		            field.setValue(String.valueOf(dobSplit1[1].charAt(i)) );
	            }
	    	    
	    	    for (int i = 0; i < dobSplit1[2].length(); i++) {
	    	    	int ii = i+1;
	    	    	 field = pDAcroForm.getField("year2_"+ii);
		            field.setValue(String.valueOf(dobSplit1[2].charAt(i)) );
	            }
	            
	    	    field = pDAcroForm.getField("permanent_address_first2");
	            field.setValue(person2.getAddressPermanentNo());
	            
	            field = pDAcroForm.getField("permanent_address_second2");
	            field.setValue(person2.getAddressPermanentStreet1()+" "+person2.getAddressPermanentStreet2()+" "+person2.getAddressPermanentCity());
	            
	            field = pDAcroForm.getField("residential_address_first2");
	            field.setValue(person2.getAddressResidentNo());
	            
	            field = pDAcroForm.getField("residential_address_second2");
	            field.setValue(person2.getAddressResidentStreet1()+" "+person2.getAddressResidentStreet2()+" "+person2.getAddressResidentCity());
	            
	            field = pDAcroForm.getField("mobile2");
	            field.setValue(person2.getMobileNo());
	            
	            field = pDAcroForm.getField("residence2");
	            field.setValue(person2.getResidentNo());
	            
	            field = pDAcroForm.getField("email2");
	            field.setValue(person2.getEmailAddress());
	            
	            
	            for (int i = 0; i <person2.getNicNo().length(); i++) {
	            	int ii = i+1;
	    	    	 field = pDAcroForm.getField("nic2_"+ii);
		            field.setValue(String.valueOf(person2.getNicNo().charAt(i)) );
	            }
	            
	            
	            pDDocument.save("C:/Users/divsi/OneDrive/Desktop/Financial Form/Home-loans-en.pdf");
	           
	            
	            pDDocument.getClass();

	            if (!pDDocument.isEncrypted()) {
	            
	                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
	                stripper.setSortByPosition(true);

	                PDFTextStripper tStripper = new PDFTextStripper();

	                String pdfFileInText = tStripper.getText(pDDocument);
	                String lines[] = pdfFileInText.split("\\r?\\n");
	                for (String line : lines) {
	                    System.out.println(line);
	                }

	            }
	            
	            pDDocument.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	
		return "redirect:/finance//fill/form";
	
	}

	
}

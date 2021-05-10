package com.eNIC.FinancialInstitution.eNICFinancialInstitution;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class createpdf {

	 public static void main(String[] args) {
	        try {
	            PDDocument pDDocument = PDDocument.load(new File("src/main/resources/static/Home-loans-en.pdf"));
	            PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();
	            
	            PDField field = pDAcroForm.getField("name1");
	            field.setValue("Amarakoon Appuhamillage Nipun Jayasanka Amarakoon");
	            
	            field = pDAcroForm.getField("date1_1");
	            field.setValue("2");
	            
	            field = pDAcroForm.getField("date1_2");
	            field.setValue("1");
	            
	            field = pDAcroForm.getField("month1_1");
	            field.setValue("0");
	            
	            field = pDAcroForm.getField("month1_2");
	            field.setValue("4");
	            
	            field = pDAcroForm.getField("year1_1");
	            field.setValue("2");
	            
	            field = pDAcroForm.getField("year1_2");
	            field.setValue("0");
	            
	            field = pDAcroForm.getField("year1_3");
	            field.setValue("0");
	            
	            field = pDAcroForm.getField("year1_4");
	            field.setValue("0");
	            
	            field = pDAcroForm.getField("permanent_address_first1");
	            field.setValue("534/1/6 Prathibamawatha");
	            
	            field = pDAcroForm.getField("permanent_address_second1");
	            field.setValue("Henihaththa Biyagama");
	            
	            field = pDAcroForm.getField("residential_address_first1");
	            field.setValue("534/1 Henihaththa");
	            
	            field = pDAcroForm.getField("residential_address_second1");
	            field.setValue("Biyagama");
	            
	            field = pDAcroForm.getField("mobile1");
	            field.setValue("0778206800");
	            
	            field = pDAcroForm.getField("residence1");
	            field.setValue("0112489151");
	            
	            field = pDAcroForm.getField("email1");
	            field.setValue("nipun.jayasanka@gmail.com");
	            
	            field = pDAcroForm.getField("nic1_1");
	            field.setValue("2");
	            
	            field = pDAcroForm.getField("nic1_2");
	            field.setValue("0");
	            
	            field = pDAcroForm.getField("nic1_3");
	            field.setValue("0");
	            
	            field = pDAcroForm.getField("nic1_4");
	            field.setValue("0");
	            
	            field = pDAcroForm.getField("nic1_5");
	            field.setValue("1");
	            
	            field = pDAcroForm.getField("nic1_6");
	            field.setValue("1");
	            
	            field = pDAcroForm.getField("nic1_7");
	            field.setValue("2");
	            
	            field = pDAcroForm.getField("nic1_8");
	            field.setValue("0");
	            
	            field = pDAcroForm.getField("nic1_9");
	            field.setValue("2");
	            
	            field = pDAcroForm.getField("nic1_10");
	            field.setValue("9");
	            
	            field = pDAcroForm.getField("nic1_11");
	            field.setValue("3");
	            
	            field = pDAcroForm.getField("nic1_12");
	            field.setValue("8");
	            
	            
	            
	            
	            field = pDAcroForm.getField("name2");
	            field.setValue("Divya Nimsara Sandadevini Sitinamaluwa");
	            
	            field = pDAcroForm.getField("date2_1");
	            field.setValue("2");
	            
	            field = pDAcroForm.getField("date2_2");
	            field.setValue("3");
	            
	            field = pDAcroForm.getField("month2_1");
	            field.setValue("0");
	            
	            field = pDAcroForm.getField("month2_2");
	            field.setValue("1");
	            
	            field = pDAcroForm.getField("year2_1");
	            field.setValue("1");
	            
	            field = pDAcroForm.getField("year2_2");
	            field.setValue("9");
	            
	            field = pDAcroForm.getField("year2_3");
	            field.setValue("9");
	            
	            field = pDAcroForm.getField("year2_4");
	            field.setValue("7");
	            
	            field = pDAcroForm.getField("permanent_address_first2");
	            field.setValue("62/A Old Road Wathara");
	            
	            field = pDAcroForm.getField("permanent_address_second2");
	            field.setValue("Polgasowita");
	            
	            field = pDAcroForm.getField("mobile2");
	            field.setValue("0778221800");
	            
	            field = pDAcroForm.getField("residence2");
	            field.setValue("0112704946");
	            
	            field = pDAcroForm.getField("email2");
	            field.setValue("divya.sitinamaluwa@gmail.com");
	            
	            field = pDAcroForm.getField("nic2_1");
	            field.setValue("9");
	            
	            field = pDAcroForm.getField("nic2_2");
	            field.setValue("7");
	            
	            field = pDAcroForm.getField("nic2_3");
	            field.setValue("5");
	            
	            field = pDAcroForm.getField("nic2_4");
	            field.setValue("2");
	            
	            field = pDAcroForm.getField("nic2_5");
	            field.setValue("3");
	            
	            field = pDAcroForm.getField("nic2_6");
	            field.setValue("2");
	            
	            field = pDAcroForm.getField("nic2_7");
	            field.setValue("7");
	            
	            field = pDAcroForm.getField("nic2_8");
	            field.setValue("6");
	            
	            field = pDAcroForm.getField("nic2_9");
	            field.setValue("0");
	            
	            field = pDAcroForm.getField("nic2_10");
	            field.setValue("V");
	            
	            pDDocument.save("C:/Users/nipun/Desktop/New folder/pdf-java-output.pdf");
	           
	            
	            pDDocument.getClass();

	            if (!pDDocument.isEncrypted()) {
	            
	                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
	                stripper.setSortByPosition(true);

	                PDFTextStripper tStripper = new PDFTextStripper();

	                String pdfFileInText = tStripper.getText(pDDocument);
	                //System.out.println("Text:" + st);

	                // split by whitespace
	                String lines[] = pdfFileInText.split("\\r?\\n");
	                for (String line : lines) {
	                    System.out.println(line);
	                }

	            }
	            
	            pDDocument.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}

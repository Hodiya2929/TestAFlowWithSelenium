package com.selenium_test.imanueleyal.quickstart;

import java.io.File;
import java.io.IOException;

import javax.annotation.Nonnull;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class IdenticationDetails {
	
	@Nonnull
	private String userName;
	@Nonnull
	private String password;
	
	public void parseXmlUserData() throws ParserConfigurationException, IOException, SAXException {
		
		
		File inputFile = new File("resources/Identification.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			
			System.out.println("Found a configuration error!");
			e.printStackTrace();
			throw e;
			
		}
		
        Document doc = null;
        
		try {
			doc = dBuilder.parse(inputFile);
		} catch (SAXException e) {
			System.out.println("Cannot parse the document");
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			System.out.println("Cannot continue, has I/O issue");
			e.printStackTrace();
			throw e;
		}
		
       doc.getDocumentElement().normalize();
       
       this.userName = doc.getElementsByTagName("user").item(0).getTextContent();
       this.password = doc.getElementsByTagName("pass").item(0).getTextContent();
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	
	
	

}

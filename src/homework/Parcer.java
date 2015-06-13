package homework;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parcer {
	private String movie;
	private String book;
	
	public String getMovie(){
		return movie;
	}
	
	public String getBook(){
		return book;
	}
	
	public void parceXML() throws ParserConfigurationException, SAXException, IOException{
		
		File fXmlFile = new File("ListOfQuotes.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = (Document) dBuilder.parse(fXmlFile);
			 
		doc.getDocumentElement().normalize();
			 
		NodeList quotesfm = doc.getElementsByTagName("QuoteFM");
		NodeList quotesfb = doc.getElementsByTagName("QuoteFB");
				
		Random rand = new Random();
		int randomQuoteFB = rand.nextInt(20);
	    int randomQuoteFM = rand.nextInt(20);
				
		Node fromBooks = quotesfb.item(randomQuoteFB);
		Node fromMovies = quotesfm.item(randomQuoteFM);
				
		if (fromMovies.getNodeType() == Node.ELEMENT_NODE && fromBooks.getNodeType() == Node.ELEMENT_NODE) {
		Element elementFM = (Element) fromMovies;
		Element elementFB = (Element) fromBooks;
					
		movie = "�����: " + elementFM.getAttribute("Thought")+"<br/>"+
			   "����: "+ elementFM.getAttribute("Movie")+"<br/>"+
	                   "������: " + elementFM.getAttribute("Year")+"<br/>"+
	                   "����: "+ elementFM.getAttribute("Subject")+"<br/>";
	        
		book = "�����: " + elementFB.getAttribute("Thought")+"<br/>"+
	                    "�����: " + elementFB.getAttribute("Book")+"<br/>"+
	                    "������ �� ����������: " + elementFB.getAttribute("YearOfPublication")+"<br/>"+
	                    "�����: "+ elementFB.getElementsByTagName("Author").item(0).getTextContent()+"<br/>"+
	                    "����: " + elementFB.getAttribute("Subject")+"<br/>";
		} 
	}
}

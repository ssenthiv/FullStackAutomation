package collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;




public class xmlHandling {

	public static void main(String[] args) {
		
		
		String strSourceXMLFile;
		String strDestXMLFile;
		
		System.out.println(System.getProperty("user.dir")+"\\src\\main\\resources\\inputData\\tc_nd_06_TextualNearDupResults_actual.xml");
		
		strSourceXMLFile=System.getProperty("user.dir")+"\\src\\main\\resources\\inputData\\tc_nd_06_TextualNearDupResults_actual.xml";
		
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLEventReader eventReader=null;
		
		try {
			eventReader=factory.createXMLEventReader(new FileReader(new File(strSourceXMLFile) ));
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (XMLStreamException e) {
			
			e.printStackTrace();
		}
		
		XMLEvent event=null;
		StartElement startElement = null;
		String qName = null;
		while (eventReader.hasNext()){
			
			try {
				event=eventReader.nextEvent();
			} catch (XMLStreamException e) {

				e.printStackTrace();
			}
			
			// System.out.println(event);
			
			//System.out.println(event.getEventType());
			
			if (event.getEventType() == (XMLStreamConstants.START_ELEMENT)){
				
			
			startElement=event.asStartElement();
			qName=startElement.getName().getLocalPart();
			
			if (qName.equalsIgnoreCase("item")){
				
				Iterator<Attribute> itrAttribute =startElement.getAttributes();
				Attribute attribute=itrAttribute.next();
				 
				/*System.out.print(attribute.getName()+" = ");
				String itemId=attribute.getValue();
				System.out.println(itemId);*/
				
			}
			if (qName.equalsIgnoreCase("meta")){
				
				Iterator<Attribute> itrAttribute =startElement.getAttributes();
				Attribute attribute=itrAttribute.next();
				 
				System.out.print(attribute.getName()+" = ");
				String itemId=attribute.getValue();
				System.out.println(itemId);
				
			}
			
			/*
			System.out.println("start element: "+ startElement);
			System.out.println("QName :"+ startElement.getName());
			System.out.println("Local part: "+ qName);
			*/
			}
			
			Characters character=null;
			String name=null;
			
			if (event.getEventType() == (XMLStreamConstants.CHARACTERS)){
				
				
				character=event.asCharacters();
				name=character.getData();
				
				System.out.println("Characters: "+ character);
				System.out.println("name : "+ name);
				
				}
			
		}
		
	}

}

package com.vivi.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4JUtil {
	private static String dbFilePath = "";
	
	public static Document getDocument(String res) throws DocumentException {
		ClassLoader cl = Dom4JUtil.class.getClassLoader();
		URL url = cl.getResource("database/"+res);
		dbFilePath = url.getPath();
		
		SAXReader reader = new SAXReader();
		return reader.read(dbFilePath);	
	} 
	
	public static void write2xml(Document doc, String res) throws  FileNotFoundException, IOException {
		ClassLoader cl = Dom4JUtil.class.getClassLoader();
		URL url = cl.getResource("database/"+res);
		dbFilePath = url.getPath();
		
		XMLWriter writer = new XMLWriter(new FileOutputStream(dbFilePath), OutputFormat.createPrettyPrint());
		writer.write(doc);
		writer.close();
	}

}

package com.frogans.designer.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.xpath.XPathEvaluator;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by naouf on 3/19/2016.
 */
public class FsdlParser {
    private File file;

    public FsdlParser(String filename){
        this.file= new File(filename);
    }

    public void parseFileElement(){
        try{

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("frogans-fsdl");
            Element element = (Element) nodeList.item(0);

            NodeList nodeList1 = element.getElementsByTagName("layer");
            for (int i = 0; i < nodeList1.getLength(); i++) {
                Element element1 = (Element) nodeList1.item(i);
                System.out.println("layer ID: "+element1.getAttributes().getNamedItem("layerid").getNodeValue());
                System.out.println("resref: "+element1.getAttributes().getNamedItem("resref").getNodeValue());
            }

        }catch (Exception e){
            System.err.println("Problem in parsing file.\n"+e);
        }


    }


    public void parseFileXPath() throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document doc = documentBuilder.parse(file);
        doc.getDocumentElement().normalize();

        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();

        String expression;
        Node node;
        NodeList nodeList;

        expression="/*";
        node = (Node) xpath.evaluate(expression,doc, XPathConstants.NODE);
        //System.out.println(node.getNodeName());

        expression="/frogans-fsdl/*";
        nodeList = (NodeList) xpath.evaluate(expression,doc, XPathConstants.NODESET);

//        Element element = (Element) nodeList.item(0);
//        System.out.println(element.getAttributes().getNamedItem("layerid").getNodeValue());

        NodeList nodeList1;
        for (int i = 0; i < nodeList.getLength(); i++) {
            String aTag = nodeList.item(i).getNodeName();
            System.out.println(aTag);
            expression="/frogans-fsdl/"+aTag+"/*";
            nodeList1 = (NodeList) xpath.evaluate(expression,doc,XPathConstants.NODESET);

            for (int j = 0; j < nodeList1.getLength(); j++) {
                System.out.println("\t"+nodeList1.item(j).getNodeName());
            }
            expression="";
        }
    }

}

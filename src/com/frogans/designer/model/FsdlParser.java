package com.frogans.designer.model;

import javafx.scene.control.TreeItem;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
 * Created by Naoufal EL BANTLI on 3/19/2016.
 */
public class FsdlParser {
    private File file;

    public FsdlParser(String filename) {
        this.file = new File(filename);
    }

    public void parseFileElement() {
        try {

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("frogans-fsdl");
            Element element = (Element) nodeList.item(0);

            NodeList nodeList1 = element.getElementsByTagName("layer");
            for (int i = 0; i < nodeList1.getLength(); i++) {
                Element element1 = (Element) nodeList1.item(i);
                System.out.println("layer ID: " + element1.getAttributes().getNamedItem("layerid").getNodeValue());
                System.out.println("resref: " + element1.getAttributes().getNamedItem("resref").getNodeValue());
            }

        } catch (Exception e) {
            System.err.println("Problem in parsing file.\n" + e);
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

        expression = "/*";
        node = (Node) xpath.evaluate(expression, doc, XPathConstants.NODE);
        //System.out.println(node.getNodeName());

        expression = "/frogans-fsdl/*";
        nodeList = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);

//        Element element = (Element) nodeList.item(0);
//        System.out.println(element.getAttributes().getNamedItem("layerid").getNodeValue());

        NodeList nodeList1;


//        for (int i = 0; i < nodeList.getLength(); i++) {
//            String aTag = nodeList.item(i).getNodeName();
//
//            //System.out.println(aTag);
//            expression = "/frogans-fsdl/" + aTag + "/*";
//            nodeList1 = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);
//            System.out.println(nodeList1);
//
////            for (int j = 0; j < nodeList1.getLength(); j++) {
////
////                System.out.println("\t"+nodeList1.item(j).getNodeName());
////                //TODO
////                //Display what's inside each tag
////            }
//
//            expression = "";
//        }

        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i).getNodeName());
            expression="*";
            nodeList1 = (NodeList) xpath.evaluate(expression,nodeList.item(i),XPathConstants.NODESET);
            for (int j = 0; j < nodeList1.getLength(); j++) {
                System.out.println("\t"+nodeList1.item(j).getNodeName());
            }
        }



    }

    public void momamak() {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(file);
            doc.getDocumentElement().normalize();


            //doc.getDocumentElement() returns the root element of the file
            NodeList nodeList = doc.getElementsByTagName(doc.getDocumentElement().getNodeName());

            Element element = (Element) nodeList.item(0);

            // Getting elements like button, layer....
            NodeList nodeList1 = element.getChildNodes();


            for (int i = 0; i < nodeList1.getLength(); i++) {
                Node node = nodeList1.item(i);
                if (node.getNodeType() != Node.COMMENT_NODE && node.getNodeType() != Node.TEXT_NODE) {
                    System.out.println(node.getNodeName());
                    ifTageisLayer(node);


                    NodeList nodeList2 = node.getChildNodes();
                    for (int j = 0; j < nodeList2.getLength(); j++) {
                        Node node1 = nodeList2.item(j);
                        if (node1.getNodeType() != Node.TEXT_NODE){
                            System.out.println("\t" + node1.getNodeName());
                            ifTageisLayer(node1);
                            if(node1.getNodeName().equals("text")){
                                //Element element1 = (Element) node1;
                                System.out.println("\t\t"+node1.getTextContent());
                            }
                        }

                    }
                }

            }

            Node node = element.getFirstChild();

            //System.out.println(node.getNextSibling());


        } catch (Exception e) {
            System.err.println("lkjhgf.\n" + e);
        }

    }

    private void ifTageisLayer(Node node) {
        if (node.getNodeName().equals("layer")) {

            Element layer = (Element) node;
            String id = layer.getAttribute(FSDLElements.LayerAttributes.layerid.toString());
            String leapout= layer.getAttribute(FSDLElements.LayerAttributes.leapout.toString());
            String resref= layer.getAttribute(FSDLElements.LayerAttributes.resref.toString());
            String reliefref=layer.getAttribute(FSDLElements.LayerAttributes.reliefref.toString());
            String opacity=layer.getAttribute(FSDLElements.LayerAttributes.opacity.toString());
            String pos=layer.getAttribute(FSDLElements.LayerAttributes.pos.toString());
            String align=layer.getAttribute(FSDLElements.LayerAttributes.align.toString());
            String combine=layer.getAttribute(FSDLElements.LayerAttributes.combine.toString());
            System.out.println("\t"+id+","+leapout+","+resref+","+reliefref+","+opacity+","+pos+","+align+","+combine);
        }
    }

}

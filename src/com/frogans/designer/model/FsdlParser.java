package com.frogans.designer.model;


import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.util.*;

/**
 * Created by Naoufal EL BANTLI on 3/19/2016.
 */
public class FsdlParser {
    private File file;

    public FsdlParser(String filename) {
        this.file = new File(filename);
    }

    //
//    public void parseFileElement() {
//        try {
//
//            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
//            Document doc = documentBuilder.parse(file);
//            doc.getDocumentElement().normalize();
//
//            NodeList nodeList = doc.getElementsByTagName("frogans-fsdl");
//            Element element = (Element) nodeList.item(0);
//
//            NodeList nodeList1 = element.getElementsByTagName("layer");
//            for (int i = 0; i < nodeList1.getLength(); i++) {
//                Element element1 = (Element) nodeList1.item(i);
//                System.out.println("layer ID: " + element1.getAttributes().getNamedItem("layerid").getNodeValue());
//                System.out.println("resref: " + element1.getAttributes().getNamedItem("resref").getNodeValue());
//            }
//
//        } catch (Exception e) {
//            System.err.println("Problem in parsing file.\n" + e);
//        }
//
//
//    }
//
//
//    public void parseFileXPath() throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
//        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
//        Document doc = documentBuilder.parse(file);
//        doc.getDocumentElement().normalize();
//
//        XPathFactory factory = XPathFactory.newInstance();
//        XPath xpath = factory.newXPath();
//
//        String expression;
//        Node layer;
//        NodeList nodeList;
//
//        expression = "/*";
//        layer = (Node) xpath.evaluate(expression, doc, XPathConstants.NODE);
//        //System.out.println(layer.getNodeName());
//
//        expression = "/frogans-fsdl/*";
//        nodeList = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);
//
////        Element element = (Element) nodeList.item(0);
////        System.out.println(element.getAttributes().getNamedItem("layerid").getNodeValue());
//
//        NodeList nodeList1;
//
//
////        for (int i = 0; i < nodeList.getLength(); i++) {
////            String aTag = nodeList.item(i).getNodeName();
////
////            //System.out.println(aTag);
////            expression = "/frogans-fsdl/" + aTag + "/*";
////            nodeList1 = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);
////            System.out.println(nodeList1);
////
//////            for (int j = 0; j < nodeList1.getLength(); j++) {
//////
//////                System.out.println("\t"+nodeList1.item(j).getNodeName());
//////                //TODO
//////                //Display what's inside each tag
//////            }
////
////            expression = "";
////        }
//
//        for (int i = 0; i < nodeList.getLength(); i++) {
//            System.out.println(nodeList.item(i).getNodeName());
//            expression = "*";
//            nodeList1 = (NodeList) xpath.evaluate(expression, nodeList.item(i), XPathConstants.NODESET);
//            for (int j = 0; j < nodeList1.getLength(); j++) {
//                System.out.println("\t" + nodeList1.item(j).getNodeName());
//            }
//        }
//
//
//    }
//
//    public void momamak() {
//        try {
//            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
//            Document doc = documentBuilder.parse(file);
//            doc.getDocumentElement().normalize();
//
//
//            //doc.getDocumentElement() returns the root element of the file
//            NodeList nodeList = doc.getElementsByTagName(doc.getDocumentElement().getNodeName());
//
//            Element element = (Element) nodeList.item(0);
//
//            // Getting elements like button, layer....
//            NodeList nodeList1 = element.getChildNodes();
//
//
//            for (int i = 0; i < nodeList1.getLength(); i++) {
//                Node layer = nodeList1.item(i);
//                if (layer.getNodeType() != Node.COMMENT_NODE && layer.getNodeType() != Node.TEXT_NODE) {
//                    System.out.println(layer.getNodeName());
//                    ifTagIsLayer(layer);
//
//
//                    NodeList nodeList2 = layer.getChildNodes();
//                    for (int j = 0; j < nodeList2.getLength(); j++) {
//                        Node node1 = nodeList2.item(j);
//                        if (node1.getNodeType() != Node.TEXT_NODE) {
//                            System.out.println("\t" + node1.getNodeName());
//                            ifTagIsLayer(node1);
//                            if (node1.getNodeName().equals("text")) {
//                                //Element element1 = (Element) node1;
//                                System.out.println("\t\t" + node1.getTextContent());
//                            }
//                        }
//
//                    }
//                }
//
//            }
//
//            Node layer = element.getFirstChild();
//
//            //System.out.println(layer.getNextSibling());
//
//
//        } catch (Exception e) {
//            System.err.println("lkjhgf.\n" + e);
//        }
//
//    }
//
    private void ifTagIsLayer(Element layer) {
        if (layer.getName().equals("layer")) {
            //String fuck="";
//            for(FSDLElements.LayerAttributes l : FSDLElements.LayerAttributes.values()){
//                Attribute temp = layer.getAttribute(l.toString());
//                fuck+=checkAttributeifNull(temp)+", ";
//            }
            List<FSDLElements.LayerAttributes> kkk = Arrays.asList(FSDLElements.LayerAttributes.values());
            List<String> kjh = new ArrayList<>();

            kkk.forEach(e -> {
                Attribute a = layer.getAttribute(e.toString());
                kjh.add(e.toString()+": "+checkAttributeifNull(a));
            });

            System.out.println("\t" + kjh);
        }
    }


    private void ifTagIsText(Element text) {
        if (text.getName().equals("text")) {
            System.out.println("\t\t" + text.getText());
        }
    }

    private String checkAttributeifNull(Attribute attribute) {
        if (attribute != null)
            return attribute.getValue();
        else
            return "";
    }

    public void gaga() {
        try {
            SAXBuilder saxBuilder = new SAXBuilder();

            Document document = saxBuilder.build(file);

            System.out.println("Root element :"
                    + document.getRootElement().getName());

            Element classElement = document.getRootElement();

            List<Element> studentList = classElement.getChildren();
            System.out.println("----------------------------");

            studentList.forEach(e -> {
                System.out.println(e.getName());
                ifTagIsLayer(e);

                List<Element> a = e.getChildren();
                a.forEach(i -> {
                    System.out.println("\t" + i.getName());
                    ifTagIsLayer(i);
                    ifTagIsText(i);

                });
            });


        } catch (Exception ioe) {
            System.err.println("fuck");

        }
    }

}



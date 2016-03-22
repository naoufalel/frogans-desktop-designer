package com.frogans.designer.model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TreeItem;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
//import org.jdom2.Attribute;
//import org.jdom2.Document;
//import org.jdom2.Element;
//import org.jdom2.input.SAXBuilder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.*;

/**
 * Created by Naoufal EL BANTLI on 3/19/2016.
 */
public class FsdlParser {
    private File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public FsdlParser(File file) {
        this.file = file;
    }

//    private void ifTagIsLayer(Element layer) {
//        if (layer.getName().equals("layer")) {
//            //String fuck="";
////            for(FSDLElements.LayerAttributes l : FSDLElements.LayerAttributes.values()){
////                Attribute temp = layer.getAttribute(l.toString());
////                fuck+=checkAttributeifNull(temp)+", ";
////            }
//            List<FSDLElements.LayerAttributes> kkk = Arrays.asList(FSDLElements.LayerAttributes.values());
//            List<String> kjh = new ArrayList<>();
//
//            kkk.forEach(e -> {
//                Attribute a = layer.getAttribute(e.toString());
//                kjh.add(e.toString() + ": " + checkAttributeifNull(a));
//            });
//
//            System.out.println("\t" + kjh);
//        }
//    }


//    private void ifTagIsText(Element text) {
//        if (text.getName().equals("text")) {
//            System.out.println("\t\t" + text.getText());
//        }
//    }
//
//    private String checkAttributeifNull(Attribute attribute) {
//        if (attribute != null)
//            return attribute.getValue();
//        else
//            return "";
//    }
//
//    public List<TreeItem<String>> gaga() {
//        try {
//            SAXBuilder saxBuilder = new SAXBuilder();
//
//            Document document = saxBuilder.build(file);
//
////            System.out.println("Root element :"
////                    + document.getRootElement().getName());
//
//            Element classElement = document.getRootElement();
//
//            List<Element> tagElements = classElement.getChildren();
//            //System.out.println("----------------------------");
//
//           List<TreeItem<String>> mainElements = new ArrayList<>();
//
//
//            tagElements.forEach(e -> {
//                //System.out.println(e.getName());
//                if (e.getName().equals("layer"))
//                    mainElements.add(new TreeItem<>(e.getAttribute("layerid").getValue()));
//                else
//                    mainElements.add(new TreeItem<>(e.getName()));
//
//                //ifTagIsLayer(e);
//
////                List<Element> a = e.getChildren();
////                a.forEach(i -> {
////                    System.out.println("\t" + i.getName());
////                    ifTagIsLayer(i);
////                    ifTagIsText(i);
////
////                });
//            });
//
//            return mainElements;
//        } catch (Exception e) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Problem");
//            alert.setHeaderText("Problem in opening a file");
//            alert.setContentText("There was a problem while opening " + file.getName() + ". Please check if the file exists");
//
//            alert.showAndWait();
//            System.err.println("fuck");
//
//        }
//        return null;
//    }
//
//    public List<TreeItem<String>> returnSubButton() {
//        try {
//            SAXBuilder saxBuilder = new SAXBuilder();
//
//            Document document = saxBuilder.build(file);
//
//            System.out.println("Root element :"
//                    + document.getRootElement().getName());
//
//            Element classElement = document.getRootElement();
//
//            List<Element> tagElements1 = classElement.getChildren();
//
//            List<TreeItem<String>> subButtonTags = new ArrayList<>();
//
//            tagElements1.forEach(e -> {
//                        if (e.getName().equals("button")) {
//
//                            List<Element> submok = e.getChildren();
//
//                            submok.forEach(a -> {
//                                subButtonTags.add(new TreeItem<>(a.getAttribute("layerid").getValue()));
//                            });
//                        }
//
//                    }
//            );
//
//            System.out.println("lololo");
//            return subButtonTags;
//        } catch (Exception e) {
//            System.err.println("fiick" + e);
//        }
//        return null;
//    }

    public List<TreeItem<String>> parseFsdlFile() {
        try {
            List<TreeItem<String>> a = new ArrayList<>();

            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();

            Element element = doc.getDocumentElement();
            System.out.println(element.getNodeName());
            NodeList nodeList = element.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node =  nodeList.item(i);
                if(node.getNodeType()!=Node.TEXT_NODE && node.getNodeType()!=Node.COMMENT_NODE)
                    //System.out.println(node.getNodeName());
                if(node.getNodeName().equals("layer")){
                    System.out.println(node.getNodeName());
                    Element element1 = (Element) node;
                    a.add(new TreeItem<>(element1.getAttribute("layerid")));
                }else
                    a.add(new TreeItem<>(node.getNodeName()));
            }

            return a;
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Problem in opening file");
            alert.setContentText("There was a problem parsing the file");
            alert.showAndWait();
        }
        return null;
    }
}



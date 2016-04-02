package com.frogans.designer.model;


import com.frogans.designer.model.Elements.ButtonFSDL;
import com.frogans.designer.model.Elements.FileFSDL;
import com.frogans.designer.model.Elements.LayerFSDL;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.scene.control.Alert;

import org.w3c.dom.*;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

import java.lang.reflect.Method;
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
    private String checkAttributeifNull(Element e, String s) {
        if (e.getAttribute(s) != null) {
            if (e.getNodeName().equals("button")) {
                NamedNodeMap nodeList = e.getAttributes();
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node n = nodeList.item(i);
                    if (n.getNodeName().equals("goto")) {
                        String temp = e.getAttribute("goto");
                        e.removeAttribute("goto");
                        e.setAttribute("go_to", temp);
                    }
                }
            }
            if (e.getParentNode().getNodeName().equals("button")) {
                NamedNodeMap nodeList = e.getAttributes();
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node n = nodeList.item(i);
                    if (n.getNodeName().equals("combine")) {
                        String temp = e.getAttribute("combine");
                        e.removeAttribute("combine");
                        e.setAttribute("combineButton", temp);
                    }
                }
            }
            return e.getAttribute(s);
        } else
            return "";
    }
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

    public ObservableMap<String, String> parseFsdlFile() {
        try {
            ObservableMap<String, String> a = FXCollections.observableMap(new HashMap<>());

            NodeList nodeList = getNodeListFromRoot();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (isNotTextOrComment(node)) {
                    //System.out.println(node.getNodeName());
//                if(node.getNodeName().equals("layer")){
//                    System.out.println(node.getNodeName());
//                    Element element1 = (Element) node;
//                    a.add(new TreeItem<>(element1.getAttribute("layerid")));
//                }else{
                    Element element2 = (Element) node;
                    //a.add(new TreeItem<>(getIDofElement(element2)));
                    a.put(getIDofElement(element2), element2.getNodeName());
//                }
                }
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


    private String getIDofElement(Element element) {

        List<FSDLElements.MainFsdlTags> fsdlMainTags = Arrays.asList(FSDLElements.MainFsdlTags.values());
        String a = "";
        for (FSDLElements.MainFsdlTags e : fsdlMainTags) {
            if (element.getNodeName().equals(e.toString())) {
                //TODO
//                for(FSDLElements.MainFsdlTags m : fsdlMainTags){
//                    if(e.toString().equals(m.toString())){
//
//                    }
//                }

                if (e.toString().equals("button")) {
                    a = element.getAttribute("buttonid");
                } else if (e.toString().equals("layer"))
                    a = element.getAttribute("layerid");
                else
                    a = element.getNodeName() + " ID";
            }
        }


        return a;
    }

    public void layerParsing() {
        try {

            ObservableList<LayerFSDL> layers = FXCollections.observableArrayList();
            List<FSDLElements.layerAttributes> layerAttributes = Arrays.asList(FSDLElements.layerAttributes.values());

            NodeList nodeList = getNodeListFromRoot();


            Class<?> aClass = Class.forName("com.frogans.designer.model.Elements.LayerFSDL");
            Object obj = aClass.newInstance();

            LayerFSDL l = new LayerFSDL();
            Class[] paramString = new Class[1];
            paramString[0] = String.class;

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (isNotTextOrComment(node)) {
                    if (node.getNodeName().equals("layer")) {
                        obj = aClass.newInstance();
                        for (FSDLElements.layerAttributes e : layerAttributes) {
                            Element element1 = (Element) node;
                            try {
                                Method method = aClass.getDeclaredMethod("set" + e.toString(), paramString);
                                method.invoke(obj, checkAttributeifNull(element1, e.toString()));
                            } catch (Exception e1) {
                                System.err.println("Seuury :\n" + e1);
                            }
                        }
                        layers.add((LayerFSDL) obj);
                    }
                }
            }
            layers.forEach(e -> {
                System.out.println("mok : " + e.toString());
            });
        } catch (Exception e) {
            System.err.println("fuck frogans.\n" + e);
        }
    }


    public void buttonParsing() {
        try {
            ObservableList<LayerFSDL> layers = FXCollections.observableArrayList();
            ObservableList<ButtonFSDL> buttons = FXCollections.observableArrayList();
            List<FSDLElements.layerButtonAttributes> layerButtonAttributes = Arrays.asList(FSDLElements.layerButtonAttributes.values());
            List<FSDLElements.buttonAttributes> buttonAttributes = Arrays.asList(FSDLElements.buttonAttributes.values());

            NodeList nodeList = getNodeListFromRoot();


            Class<?> aButtonClass = Class.forName("com.frogans.designer.model.Elements.ButtonFSDL");
            Object objButton = aButtonClass.newInstance();

            Class<?> aLayerClass = Class.forName("com.frogans.designer.model.Elements.LayerFSDL");
            Object objLayer = aLayerClass.newInstance();

            Class[] paramString = new Class[1];
            paramString[0] = String.class;
            Class[] paramLayer = new Class[1];
            paramLayer[0] = LayerFSDL.class;

            ButtonFSDL buttonFSDL = new ButtonFSDL();

            Element element1 = null;
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (isNotTextOrComment(node)) {
                    if (node.getNodeName().equals("button")) {
                        objButton = aButtonClass.newInstance();
                        for (FSDLElements.buttonAttributes b : buttonAttributes) {
                            element1 = (Element) node;
                            try {
                                Method method = aButtonClass.getDeclaredMethod("set" + b.toString(), paramString);
                                method.invoke(objButton, checkAttributeifNull(element1, b.toString()));
                            } catch (Exception e1) {
                                System.err.println("Seuury :\n" + e1);
                            }
                        }
                        NodeList nodeList1 = element1.getChildNodes();
                        for (int j = 0; j < nodeList1.getLength(); j++) {
                            Node node1 = nodeList1.item(j);
                            if (isNotTextOrComment(node1)) {
                                if (node1.getNodeName().equals("layer")) {
                                    objLayer = aLayerClass.newInstance();
                                    for (FSDLElements.layerButtonAttributes e : layerButtonAttributes) {
                                        Element element2 = (Element) node1;
                                        try {
                                            Method method1 = aLayerClass.getDeclaredMethod("set" + e.toString(), paramString);
                                            method1.invoke(objLayer, checkAttributeifNull(element2, e.toString()));
                                        } catch (Exception e2) {
                                            System.err.println("JKHGF :\n" + e2);
                                        }
                                    }
                                    buttonFSDL = (ButtonFSDL) objButton;
                                    buttonFSDL.getLayersButton().add((LayerFSDL) objLayer);
                                    //layers.add((LayerFSDL) objLayer);

                                }
                            }

                        }
                        buttons.add(buttonFSDL);

                    }
                }
            }

//            buttons.forEach(e->{
//                e.getLayersButton().forEach(t->{
//                    System.out.println(t);
//                });
//            });

            buttons.forEach(System.out::println);

        } catch (
                Exception e
                )

        {
            System.err.println("FUCK CHNOO.\n" + e);
        }
    }


    public void fileParsing() {
        try {

            ObservableList<FileFSDL> files = FXCollections.observableArrayList();
            List<FSDLElements.fileAttributes> fileAttribute = Arrays.asList(FSDLElements.fileAttributes.values());

            NodeList nodeList = getNodeListFromRoot();


            Class<?> aFileClass = Class.forName("com.frogans.designer.model.Elements.FileFSDL");
            Object objFile = aFileClass.newInstance();

            Class[] paramString = new Class[1];
            paramString[0] = String.class;


            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (isNotTextOrComment(node)) {
                    if (node.getNodeName().equals("file")) {
                        objFile = aFileClass.newInstance();
                        Element element = (Element) node;
                        for (FSDLElements.fileAttributes f : fileAttribute) {
                            Method m = aFileClass.getDeclaredMethod("set" + f.toString(), paramString);
                            m.invoke(objFile, checkAttributeifNull(element, f.toString()));
                        }
                        files.add((FileFSDL) objFile);
                    }
                }

            }

            files.forEach((e -> {
                System.out.println(e);
            }));

        } catch (Exception e) {
            System.err.println("oui ....\n" + e);
        }
    }


    private NodeList getNodeListFromRoot() {
        try {
            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();

            Element element = doc.getDocumentElement();
            System.out.println(element.getNodeName());

            return element.getChildNodes();
        } catch (Exception e) {
            System.err.println("Problem in parsing file");
        }
        return null;
    }

    /**
     *
     */
    public void finalParse() {
        try {
            Class[] paramString = new Class[1];
            paramString[0] = String.class;
            List<Object> AlanWalker = new ArrayList<>();

            NodeList nodeList = getNodeListFromRoot();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (isNotTextOrComment(node)) {
                    Element element = (Element) node;
                    String temp = capitalizeFirstLetter(element.getNodeName());
                    Class<?> clz = Class.forName("com.frogans.designer.model.Elements." + temp + "FSDL");
                    Object obj = clz.newInstance();
                    for (Map.Entry<String, String> entry : getEverything().entries()) {
                        if (entry.getKey().equals(element.getNodeName())) {
                            Method m = clz.getDeclaredMethod("set" + entry.getValue(), paramString);
                            m.invoke(obj, checkAttributeifNull(element, entry.getValue()));
                        }
                    }
                    AlanWalker.add(obj);
                }
            }
            AlanWalker.forEach(e -> System.out.println("test: " + e));

        } catch (Exception e) {
            System.err.println("Problem in function of parsing.\n" + e);
        }
    }

    private boolean isNotTextOrComment(Node node) {
        return node.getNodeType() != Node.TEXT_NODE && node.getNodeType() != Node.COMMENT_NODE;
    }

    private String capitalizeFirstLetter(String moak) {
        return Character.toUpperCase(moak.charAt(0)) + moak.substring(1);
    }

    private ListMultimap<String, String> getEverything() {
        try {
            ListMultimap<String, String> mapOfElementsAndTheirAttributes = ArrayListMultimap.create();


            List<FSDLElements.resdrawAttributes> resdrawAttributes = Arrays.asList(FSDLElements.resdrawAttributes.values());
            List<FSDLElements.setreliefAttributes> setreliefAttributes = Arrays.asList(FSDLElements.setreliefAttributes.values());
            List<FSDLElements.setshadowAttributes> setshadowAttributes = Arrays.asList(FSDLElements.setshadowAttributes.values());
            List<FSDLElements.respixelsAttributes> respixelsAttributes = Arrays.asList(FSDLElements.respixelsAttributes.values());
            List<FSDLElements.respathAttributes> respathAttributes = Arrays.asList(FSDLElements.respathAttributes.values());
            List<FSDLElements.resmergeAttributes> resmergeAttributes = Arrays.asList(FSDLElements.resmergeAttributes.values());
            List<FSDLElements.nextAttributes> nextAttributes = Arrays.asList(FSDLElements.nextAttributes.values());
            List<FSDLElements.layerAttributes> layerAttributes = Arrays.asList(FSDLElements.layerAttributes.values());
            List<FSDLElements.setfontAttributes> setfontAttributes = Arrays.asList(FSDLElements.setfontAttributes.values());
            List<FSDLElements.restextAttributes> restextAttributes = Arrays.asList(FSDLElements.restextAttributes.values());
            List<FSDLElements.fileAttributes> fileAttributes = Arrays.asList(FSDLElements.fileAttributes.values());
            List<FSDLElements.resimageAttributes> resimageAttributes = Arrays.asList(FSDLElements.resimageAttributes.values());
            List<FSDLElements.buttonAttributes> buttonAttributes = Arrays.asList(FSDLElements.buttonAttributes.values());


            for (FSDLElements.setreliefAttributes setreliefAttribute : setreliefAttributes) {
                mapOfElementsAndTheirAttributes.put("setrelief", setreliefAttribute.toString());
            }
            for (FSDLElements.setshadowAttributes setshadowAttribute : setshadowAttributes) {
                mapOfElementsAndTheirAttributes.put("setshadow", setshadowAttribute.toString());
            }
            for (FSDLElements.respathAttributes respathAttribute : respathAttributes) {
                mapOfElementsAndTheirAttributes.put("respath", respathAttribute.toString());
            }
            for (FSDLElements.resmergeAttributes resmergeAttribute : resmergeAttributes) {
                mapOfElementsAndTheirAttributes.put("resmerge", resmergeAttribute.toString());
            }
            for (FSDLElements.setfontAttributes setfontAttribute : setfontAttributes) {
                mapOfElementsAndTheirAttributes.put("setfont", setfontAttribute.toString());
            }
            for (FSDLElements.restextAttributes restextAttribute : restextAttributes) {
                mapOfElementsAndTheirAttributes.put("restext", restextAttribute.toString());
            }
            for (FSDLElements.layerAttributes layerAttribute : layerAttributes) {
                mapOfElementsAndTheirAttributes.put("layer", layerAttribute.toString());
            }
            for (FSDLElements.buttonAttributes buttonAttribute : buttonAttributes) {
                mapOfElementsAndTheirAttributes.put("button", buttonAttribute.toString());
            }
            for (FSDLElements.fileAttributes fileAttribute : fileAttributes) {
                mapOfElementsAndTheirAttributes.put("file", fileAttribute.toString());
            }
            for (FSDLElements.resdrawAttributes resdrawAttribute : resdrawAttributes) {
                mapOfElementsAndTheirAttributes.put("resdraw", resdrawAttribute.toString());
            }
            for (FSDLElements.respixelsAttributes respixelsAttribute : respixelsAttributes) {
                mapOfElementsAndTheirAttributes.put("respixel", respixelsAttribute.toString());
            }
            for (FSDLElements.nextAttributes nextAttribute : nextAttributes) {
                mapOfElementsAndTheirAttributes.put("next", nextAttribute.toString());
            }
            for (FSDLElements.resimageAttributes resimageAttribute : resimageAttributes) {
                mapOfElementsAndTheirAttributes.put("resimage", resimageAttribute.toString());
            }


            return mapOfElementsAndTheirAttributes;
        } catch (Exception e) {
            System.err.println("jhgf.\n" + e);
        }


        return null;
    }


    private void parseChildren(Element element) {
        switch (element.getNodeName()) {
            case "button":
                List<String> layers = new ArrayList<>();

        }
    }
}



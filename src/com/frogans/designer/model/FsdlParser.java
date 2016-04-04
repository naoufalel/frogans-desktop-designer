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
                    //System.out.println(parseChildren(element));
                }
            }
            //AlanWalker.forEach(e -> System.out.println("test: " + e));
            AlanWalker.forEach(e->{
                if(e instanceof LayerFSDL){
                    System.out.println("hola");
                }
            });

        } catch (Exception e) {
            System.err.println("Problem in function of parsing.\n" + e);
        }
    }

    private List<Object> parseChildren(Element element) {
        List<Object> MorganFreeman = new ArrayList<>();
        Class[] paramString = new Class[1];
        paramString[0] = String.class;
        try {
            switch (element.getNodeName()) {
                case "button":
                    NodeList nodeList = element.getChildNodes();
                    for (int i = 0; i < nodeList.getLength(); i++) {
                        Node node = nodeList.item(i);
                        if (isNotTextOrComment(node)) {
                            Element element1 = (Element) node;
                            String temp = capitalizeFirstLetter(element1.getNodeName());
                            Class<?> clz = Class.forName("com.frogans.designer.model.Elements." + temp + "FSDL");
                            Object obj2 = clz.newInstance();
                            for (Map.Entry<String, String> entry : getEverythingOfChildren().entries()) {
                                if (entry.getKey().equals(element1.getNodeName())) {
                                    Method m = clz.getDeclaredMethod("set" + entry.getValue(), paramString);
                                    m.invoke(obj2, checkAttributeifNull(element1, entry.getValue()));
                                }
                            }
                            MorganFreeman.add(obj2);
                        }

                    }
            }
            return MorganFreeman;
        } catch (Exception e) {
            System.err.println("WHO CAARRRES ??\n" + e);
        }
        return null;
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

    private ListMultimap<String, String> getEverythingOfChildren() {
        try {
            ListMultimap<String, String> childrenEvian = childrenEvian = ArrayListMultimap.create();

            List<FSDLElements.layerButtonAttributes> layers = Arrays.asList(FSDLElements.layerButtonAttributes.values());
            List<FSDLElements.textAttributes> textAttributes = Arrays.asList(FSDLElements.textAttributes.values());
            List<FSDLElements.fontAttributes> fontAttributes = Arrays.asList(FSDLElements.fontAttributes.values());
            List<FSDLElements.filterAttributes> filterAttributes = Arrays.asList(FSDLElements.filterAttributes.values());
            List<FSDLElements.reliefAttributes> reliefAttributes = Arrays.asList(FSDLElements.reliefAttributes.values());
            List<FSDLElements.mergeAttributes> mergeAttributes = Arrays.asList(FSDLElements.mergeAttributes.values());
            List<FSDLElements.shadowAttributes> shadowAttributes = Arrays.asList(FSDLElements.shadowAttributes.values());


            for (FSDLElements.layerButtonAttributes layer : layers) {
                childrenEvian.put("layer", layer.toString());
            }
            for (FSDLElements.textAttributes textAttribute : textAttributes) {
                childrenEvian.put("text", textAttribute.toString());
            }
            for (FSDLElements.fontAttributes fontAttribute : fontAttributes) {
                childrenEvian.put("font", fontAttribute.toString());
            }
            for (FSDLElements.filterAttributes filterAttribute : filterAttributes) {
                childrenEvian.put("filter", filterAttribute.toString());
            }
            for (FSDLElements.reliefAttributes reliefAttribute : reliefAttributes) {
                childrenEvian.put("relief", reliefAttribute.toString());
            }
            for (FSDLElements.mergeAttributes mergeAttribute : mergeAttributes) {
                childrenEvian.put("merge", mergeAttribute.toString());
            }
            for (FSDLElements.shadowAttributes shadowAttribute : shadowAttributes) {
                childrenEvian.put("shadow", shadowAttribute.toString());
            }

            return childrenEvian;
        } catch (Exception e) {
            System.err.println("NO ONE CARES.\n" + e);
        }
        return null;
    }


    private boolean isNotTextOrComment(Node node) {
        return node.getNodeType() != Node.TEXT_NODE && node.getNodeType() != Node.COMMENT_NODE;
    }

    private String capitalizeFirstLetter(String moak) {
        return Character.toUpperCase(moak.charAt(0)) + moak.substring(1);
    }
}



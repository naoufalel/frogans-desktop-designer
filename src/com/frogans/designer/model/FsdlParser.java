package com.frogans.designer.model;


import javafx.scene.control.TreeItem;
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

    public List<TreeItem<String>> gaga() {
        try {
            SAXBuilder saxBuilder = new SAXBuilder();

            Document document = saxBuilder.build(file);

            System.out.println("Root element :"
                    + document.getRootElement().getName());

            Element classElement = document.getRootElement();

            List<Element> tagElements = classElement.getChildren();
            System.out.println("----------------------------");

            List<TreeItem<String>> mainTags = new ArrayList<>();


            tagElements.forEach(e -> {
                System.out.println(e.getName());
                if(e.getName().equals("layer"))
                    mainTags.add(new TreeItem<>(e.getAttribute("layerid").getValue()));
                else
                    mainTags.add(new TreeItem<>(e.getName()));

                ifTagIsLayer(e);

                List<Element> a = e.getChildren();
                a.forEach(i -> {
                    System.out.println("\t" + i.getName());
                    ifTagIsLayer(i);
                    ifTagIsText(i);

                });
            });

            return mainTags;
        } catch (Exception e) {
            System.err.println("fuck");

        }
        return null;
    }

    public List<TreeItem<String>> returnSubButton(){
        try{
            SAXBuilder saxBuilder = new SAXBuilder();

            Document document = saxBuilder.build(file);

            System.out.println("Root element :"
                    + document.getRootElement().getName());

            Element classElement = document.getRootElement();

            List<Element> tagElements1 = classElement.getChildren();

            List<TreeItem<String>> subButtonTags = new ArrayList<>();

            tagElements1.forEach(e->{
                        if(e.getName().equals("button")){

                            List<Element> submok = e.getChildren();

                            submok.forEach(a->{
                        subButtonTags.add(new TreeItem<>(a.getAttribute("layerid").getValue()));
                    });
                }

            }
            );

            System.out.println("lololo");
            return subButtonTags;
        }catch (Exception e){
            System.err.println("fiick"+e);
        }
        return null;
    }

}



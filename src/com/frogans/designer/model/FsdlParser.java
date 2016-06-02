package com.frogans.designer.model;


import com.frogans.designer.model.Elements.*;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import frogans.fsdl.Fsdl;
import frogans.upil.UpilBuffer;
import frogans.upil.UpilInteger32;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.frogans.designer.Utils.Tools.capitalizeFirstLetter;


/**
 * Created by Naoufal EL BANTLI on 3/19/2016.
 */
public class FsdlParser {
    private File file;
    private int slideHandle;
    private Fsdl.Composition leadRepresentation;
    private Fsdl.Composition vignetteRepresentation;

    public FsdlParser(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    //Testing frogans lib

    public void runFsdlLib() throws ToolException {
        boolean result;

        UpilInteger32 libraryState = new UpilInteger32(Fsdl.LibraryState.UNDEFINED);
        UpilInteger32 initializationError = new UpilInteger32(Fsdl.LibraryInitializationError.UNDEFINED);
        UpilInteger32 finalizationError = new UpilInteger32(Fsdl.LibraryFinalizationError.UNDEFINED);

        result = Fsdl.libraryGetState(libraryState, initializationError, finalizationError);
        if (!result) {
            String s;
            s = "Fsdl.libraryGetState() Failure (no failure code available)";
            System.out.println(s);
            throw new ToolException(s);
        }

        String stateString = "unrecognized";
        String initializationErrorString = "n/a";
        String finalizationErrorString = "n/a";

        if (libraryState.getValue() == Fsdl.LibraryState.UNDEFINED) {

            stateString = "UNDEFINED";
        } else if (libraryState.getValue() == Fsdl.LibraryState.NOT_INITIALIZED) {

            stateString = "NOT_INITIALIZED";
        } else if (libraryState.getValue() == Fsdl.LibraryState.INITIALIZATION_HAS_FAILED) {

            stateString = "INITIALIZATION_HAS_FAILED";

            if (initializationError.getValue() == Fsdl.LibraryInitializationError.UNDEFINED) {

                initializationErrorString = "UNDEFINED";
            } else if (initializationError.getValue() == Fsdl.LibraryInitializationError.NO_ERROR) {

                initializationErrorString = "NO_ERROR";
            } else if (initializationError.getValue() == Fsdl.LibraryInitializationError.INVALID_LIBRARY_VERSION) {

                initializationErrorString = "INVALID_LIBRARY_VERSION";
            } else {

                initializationErrorString = "INTERNAL FAILURE (" + initializationError.getValue() + ")";
            }
        } else if (libraryState.getValue() == Fsdl.LibraryState.INITIALIZED) {

            stateString = "INITIALIZED";
        } else if (libraryState.getValue() == Fsdl.LibraryState.FINALIZATION_HAS_FAILED) {

            stateString = "FINALIZATION_HAS_FAILED";

            if (finalizationError.getValue() == Fsdl.LibraryFinalizationError.UNDEFINED) {

                finalizationErrorString = "UNDEFINED";
            } else if (finalizationError.getValue() == Fsdl.LibraryFinalizationError.NO_ERROR) {

                finalizationErrorString = "NO_ERROR";
            } else {

                finalizationErrorString = "INTERNAL FAILURE (" + finalizationError.getValue() + ")";
            }
        } else if (libraryState.getValue() == Fsdl.LibraryState.FINALIZED) {

            stateString = "FINALIZED";
        }

        System.out.println("Fsdl.libraryGetState() OK" +
                " - state = '" + stateString + "'" +
                " - initializationError = '" + initializationErrorString + "'" +
                " - finalizationError = '" + finalizationErrorString + "'");

        UpilInteger32 failureCode;

        UpilInteger32 handle = new UpilInteger32(Fsdl.SLIDE_HANDLE_UNDEFINED);

        Fsdl.Configuration configuration = new Fsdl.Configuration();
        configuration.stringEncoding = Fsdl.StringEncoding.UTF8;
        configuration.imageFormat = Fsdl.ImageFormat.ENCODED_PNG;
        configuration.maskFormat = Fsdl.MaskFormat.ENCODED_PNG;
        UpilBuffer buffer = new UpilBuffer();
        try {
            buffer.setValue(("./src/frogans/fonts").getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new ToolException(e + "\nProblem in the fonts file!");
        }
        configuration.fontsFileDirectory = buffer;

        failureCode = new UpilInteger32(Fsdl.FAILURE_CODE_UNDEFINED);

        result = Fsdl.slideHandleCreate(configuration, handle, failureCode);
        if (!result) {

            String s;
            s = "Fsdl.slideHandleCreate() Failure: " + failureCode;
            System.out.println(s);
            throw new ToolException(s);
        }

        slideHandle = handle.getValue();

        System.out.println("Fsdl.slideHandleCreate() OK");

		/* create lead and vignette representations */

        leadRepresentation = new Fsdl.Composition();
        vignetteRepresentation = new Fsdl.Composition();

        renderingAndValidatingWithoutDisplaying();


    }

    private void renderingAndValidatingWithoutDisplaying() throws ToolException {
        byte[] fsdlDocumentBytes = new byte[16384];
        try {
            fsdlDocumentBytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        UpilInteger32 failureCode;
        boolean result;

		/* call Fsdl.slideHandleClear() */

        failureCode = new UpilInteger32(Fsdl.FAILURE_CODE_UNDEFINED);

        result = Fsdl.slideHandleClear(slideHandle, failureCode);
        if (!result) {

            String s;
            s = "Fsdl.slideHandleClear() Failure: " + failureCode;
            System.out.println(s);
            throw new ToolException(s);
        }

        System.out.println("Fsdl.slideHandleClear() OK");


        int documentEncoding = Fsdl.DocumentEncoding.UTF8;

        int documentFsdlVersion = Fsdl.DocumentFsdlVersion.FSDL_3_0;

        UpilBuffer documentContent = new UpilBuffer(fsdlDocumentBytes);

        failureCode = new UpilInteger32(Fsdl.FAILURE_CODE_UNDEFINED);

        result = Fsdl.parsePerform(slideHandle, documentEncoding, documentFsdlVersion, documentContent, failureCode);
        if (!result) {

			/* Should never occur if the FSDL document is generated properly.
             * parseGetXmlErrorInfo() and parseGetValidationErrorInfo() are called below for debug purposes */

            String message;
            message = "parsePerform() Failure: " + failureCode + '\n';

            int code = failureCode.getValue();

            if (code == Fsdl.FailureCodeParsePerform.XML_ERROR) {

				/* call Fsdl.parseGetXmlErrorInfo() */

                Fsdl.XmlErrorInfo xmlErrorInfo = new Fsdl.XmlErrorInfo();

                failureCode = new UpilInteger32(Fsdl.FAILURE_CODE_UNDEFINED);

                result = Fsdl.parseGetXmlErrorInfo(slideHandle, xmlErrorInfo, failureCode);
                if (!result) {

                    String s;
                    s = "Fsdl.parseGetXmlErrorInfo() Failure: " + failureCode;
                    System.out.println(s);
                    throw new ToolException(s);

                }

                message += "XML Error: '" + new String(xmlErrorInfo.message.getValue()) + "'";

            } else if (code == Fsdl.FailureCodeParsePerform.VALIDATION_ERROR) {

				/* call Fsdl.parseGetValidationErrorInfo() */

                Fsdl.ValidationErrorInfo validationErrorInfo = new Fsdl.ValidationErrorInfo();

                failureCode = new UpilInteger32(Fsdl.FAILURE_CODE_UNDEFINED);

                result = Fsdl.parseGetValidationErrorInfo(slideHandle, validationErrorInfo, failureCode);
                if (!result) {

                    String s;
                    s = "Fsdl.parseGetValidationErrorInfo() Failure: " + failureCode;
                    System.out.println(s);
                    throw new ToolException(s);

                }

                message += "Validation Error: '" + new String(validationErrorInfo.message.getValue()) + "'";

            }

            System.out.println(message);

            throw new ToolException(message);
        }

        System.out.println("Fsdl.parsePerform() OK");

        int renderMode = Fsdl.RenderMode.RENDERING_CANVAS;

        failureCode = new UpilInteger32(Fsdl.FAILURE_CODE_UNDEFINED);

        result = Fsdl.renderPerform(slideHandle, renderMode, failureCode);
        if (!result) {

            String s;
            s = "Fsdl.renderPerform() Failure: " + failureCode;
            System.out.println(s);
            throw new ToolException(s);
        }

        System.out.println("Fsdl.renderPerform() OK");

        failureCode = new UpilInteger32(Fsdl.FAILURE_CODE_UNDEFINED);

        result = Fsdl.renderGetRenderingCanvas(slideHandle, leadRepresentation, vignetteRepresentation, failureCode);
        if (!result) {

            String s;
            s = "Fsdl.renderGetRenderingCanvas() Failure: " + failureCode;
            System.out.println(s);
            throw new ToolException(s);
        }

        System.out.println("Fsdl.renderGetRenderingCanvas() OK");

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
    public ObservableList<Object> finalParse() {
        try {
            Class[] paramString = new Class[1];
            paramString[0] = String.class;
            ObservableList<Object> AlanWalker = FXCollections.observableArrayList();

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
                    obj = parseChildren(element, obj);
                    AlanWalker.add(obj);
                }
            }
            return AlanWalker;
        } catch (Exception e) {
            System.err.println("Problem in function of parsing.\n" + e);
        }
        return null;
    }

    private Object parseChildren(Element element, Object obj) {
        Class[] paramString = new Class[1];
        paramString[0] = String.class;
        try {
            switch (element.getNodeName()) {
                case "button":
                    ButtonFSDL hola = (ButtonFSDL) obj;
                    NodeList nodeList = element.getChildNodes();
                    for (int i = 0; i < nodeList.getLength(); i++) {
                        Node node = nodeList.item(i);
                        if (isNotTextOrComment(node)) {
                            Object obj2 = getObjectWhenChild(paramString, (Element) node);
                            hola.getLayersButton().add((LayerFSDL) obj2);
                        }
                    }
                    return hola;

                case "restext":
                    RestextFSDL we = (RestextFSDL) obj;
                    NodeList nodeList1 = element.getChildNodes();
                    for (int i = 0; i < nodeList1.getLength(); i++) {
                        Node node = nodeList1.item(i);
                        if (isNotTextOrComment(node)) {
                            Object obj2 = getObjectWhenChild(paramString, (Element) node);
                            we.getTexts().add((TextFSDL) obj2);
                        }
                    }
                    return we;

                case "resmerge":
                    ResmergeFSDL dem = (ResmergeFSDL) obj;
                    NodeList nodeList2 = element.getChildNodes();
                    for (int i = 0; i < nodeList2.getLength(); i++) {
                        Node node = nodeList2.item(i);
                        if (isNotTextOrComment(node)) {
                            Object obj2 = getObjectWhenChild(paramString, (Element) node);
                            dem.getMerges().add((MergeFSDL) obj2);
                        }
                    }
                    return dem;

                case "setfont":
                    SetfontFSDL boyz = (SetfontFSDL) obj;
                    NodeList nodeList3 = element.getChildNodes();
                    for (int i = 0; i < nodeList3.getLength(); i++) {
                        Node node = nodeList3.item(i);
                        if (isNotTextOrComment(node)) {
                            Object obj2 = getObjectWhenChild(paramString, (Element) node);
                            boyz.getFonts().add((FontFSDL) obj2);
                        }
                    }
                    return boyz;

                case "setfilter":
                    SetfilterFSDL lets = (SetfilterFSDL) obj;
                    NodeList nodeList4 = element.getChildNodes();
                    for (int i = 0; i < nodeList4.getLength(); i++) {
                        Node node = nodeList4.item(i);
                        if (isNotTextOrComment(node)) {
                            Object obj2 = getObjectWhenChild(paramString, (Element) node);
                            lets.getFilters().add((FilterFSDL) obj2);
                        }
                    }
                    return lets;

                case "setrelief":
                    SetreliefFSDL make = (SetreliefFSDL) obj;
                    NodeList nodeList5 = element.getChildNodes();
                    for (int i = 0; i < nodeList5.getLength(); i++) {
                        Node node = nodeList5.item(i);
                        if (isNotTextOrComment(node)) {
                            Object obj2 = getObjectWhenChild(paramString, (Element) node);
                            make.getReliefs().add((ReliefFSDL) obj2);
                        }
                    }
                    return make;

                case "setshadow":
                    SetshadowFSDL noise = (SetshadowFSDL) obj;
                    NodeList nodeList6 = element.getChildNodes();
                    for (int i = 0; i < nodeList6.getLength(); i++) {
                        Node node = nodeList6.item(i);
                        if (isNotTextOrComment(node)) {
                            Object obj2 = getObjectWhenChild(paramString, (Element) node);
                            noise.getShadows().add((ShadowFSDL) obj2);
                        }
                    }
                    return noise;

                default:
                    return obj;
            }

        } catch (Exception e) {
            System.err.println("WHO CAARRRES ??\n" + e);
        }
        return null;
    }

    private Object getObjectWhenChild(Class[] paramString, Element node) {
        try {
            Element element = node;
            String temp = capitalizeFirstLetter(element.getNodeName());
            Class<?> clz = Class.forName("com.frogans.designer.model.Elements." + temp + "FSDL");
            Object obj = clz.newInstance();
            for (Map.Entry<String, String> entry : getEverythingOfChildren().entries()) {
                if (entry.getKey().equals(element.getNodeName())) {
                    Method m = clz.getDeclaredMethod("set" + entry.getValue(), paramString);
                    m.invoke(obj, checkAttributeifNull(element, entry.getValue()));
                }
            }
            return obj;
        } catch (Exception e) {
            System.err.println("IRRELEVANT.\n" + e);
        }
        return null;
    }

    /**
     * Converts all the enums to one Map (using Guava)
     *
     * @return
     */
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


}



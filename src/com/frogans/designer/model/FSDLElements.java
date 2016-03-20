package com.frogans.designer.model;

/**
 * Created by Naoufal EL BANTLI on 3/20/2016.
 */


public class FSDLElements{

    public enum MainFsdlTags {
        resdraw,
        setrelief,
        layer,
        setfont,
        restext,
        file,
        resimage,
        button
    }

    public enum SubFsdlTags{
        relief,
        font,
        text,
        layer
    }

    public enum LayerAttributes{
        layerid,
        leapout,
        resref,
        reliefref,
        opacity,
        pos,
        align,
        combine
    }

    public enum ResdrawAttributes{
        resid,
        size,
        figure,
        stroke,
        round,
        color
    }

}

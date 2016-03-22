package com.frogans.designer.model;

/**
 * Created by Naoufal EL BANTLI on 3/20/2016.
 */


public class FSDLElements {


    public enum MainFsdlTags {
        resdraw,
        setrelief,
        setshadow,
        respixels,
        respath,
        resmerge,
        next,
        layer,
        setfont,
        restext,
        file,
        resimage,
        button
    }

    public enum SubFsdlTags {
        relief,
        font,
        text,
        layer
    }

    public enum FileFsdlTags {
        fileid,
        nature,
        name,
        cache
    }

    public enum layerAttributes {
        layerid,
        leapout,
        resref,
        flip,
        filterref,
        reliefref,
        blur,
        opacity,
        angle,
        pos,
        align,
        combine,
        shadowref,
        visible
    }

    public enum buttonAttributes {
        buttonid,
        go_to, //TODO original name is goto
        fileref,
        address,
        url,
        email
    }

    public enum resdrawAttributes {
        resid,
        size,
        figure,
        stroke,
        thick,
        round,
        //color
    }

    public enum nextAttributes {
        delay,
        fileref
    }

    public enum resimageAttributes {
        resid,
        size,
        fileref,
        //selection,
        bounds,
        //aspect,
        adjust,
        origin
    }

    public enum respixelsAttributes {
        resid,
        size,
        columns,
        row,
        pix,
        color,
        alpha

    }

    public enum respathAttributes {
        resid,
        size,
        crop,
        corners,
        stroke,
        thick,
        close,
        fill,
        spread,
        adjust,
        //color
    }

    public enum setfontAttributes {
        fontid
    }

    public enum fontAttributes {
        scripts,
        pfont,
        height,
        spacing,
        //stretching,
        //xbold,
        //xitalic,
        //underline,
        //strikeout,
        //opacity,
        //color
    }

    public enum restextAttributes {
        resid,
        size,
        orientation,
        fontref,
        //talign,
        //linespace,
        vstyle
    }

    public enum textAttributes {
        //fontref,
        //talign,
        //linespace,
        vstyle,
        //join
    }

    public enum setfilterAttribute {
        filterid
    }

    public enum filterAttributes {
        effect,
        level,
        angle,
        tolerance,
        color
    }

    public enum setreliefAttribute {
        reliefid
    }

    public enum reliefAttributes {
        rpos
        //color,
        //blur,
        //opacity,
    }

    public enum setshadowAttribute {
        shadowid
    }

    public enum shadowAttributes {
        rpos,
        //color,
        //blur,
        //opacity,
        combine
    }

    public enum resmergeAttributes {
        resid,
        size
    }

    public enum mergeAttributes {
        resref,
        //flip,
        //filterref,
        //reliefref,
        //blur,
        //opacity,
        //angle,
        pos,
        //align,
        //combine,
        //shadowref,
    }

}

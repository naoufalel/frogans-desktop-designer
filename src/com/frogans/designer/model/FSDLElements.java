package com.frogans.designer.model;

/**
 * Created by Naoufal EL BANTLI on 3/20/2016.
 */


public class FSDLElements{

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

    public enum SubFsdlTags{
        relief,
        font,
        text,
        layer
    }
    public enum FileFsdlTags{
        fileid,
        nature,
        name,
        cache
    }
    public enum LayerAttributes{
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
    public enum ButtonAttributes{
        buttonid,
        go_to, //TODO original name is goto
        fileref,
        address,
        url,
        email
    }

    public enum ResdrawAttributes{
        resid,
        size,
        figure,
        stroke,
        thick,
        round,
        //color
    }

    public enum NextAttributes{
        delay,
        fileref
    }
    public enum ResimageAttributes{
        resid,
        size,
        fileref,
        //selection,
        bounds,
        //aspect,
        adjust,
        origin
    }
    public enum RespixelsAttributes{
        resid,
        size,
        columns,
        row,
        pix,
        color,
        alpha

    }
    public enum RespathAttributes{
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
    public enum SetfontAttributes{
        fontid
    }
    public enum FontAttributes{
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

    public enum RestextAttributes{
        resid,
        size,
        orientation,
        fontref,
        //talign,
        //linespace,
        vstyle
    }

    public enum TextAttributes{
        //fontref,
        //talign,
        //linespace,
        vstyle,
        //join
    }
    public enum SetfilterAttribute{
        filterid
    }

    public enum FilterAttributes{
        effect,
        level,
        angle,
        tolerance,
        color
    }

    public enum SetreliefAttribute{
        reliefid
    }
    public enum ReliefAttributes{
        rpos
        //color,
        //blur,
        //opacity,
    }
    public enum SetshadowAttribute{
        shadowid
    }
    public enum ShadowAttributes{
        rpos,
        //color,
        //blur,
        //opacity,
        combine
    }
    public enum ResmergeAttributes{
        resid,
        size
    }
    public enum MergeAttributes{
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

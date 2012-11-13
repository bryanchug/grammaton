package com.aestrea.grammaton.model

import net.sf.jmimemagic.Magic
import groovy.util.logging.Log4j

@Log4j
abstract class AbstractFile {

    String  filename
    byte[]  bytes
    String  mimeType
    String  md5sum

    static constraints = {
        filename nullable: true, blank: true, display: false, editable: false
        bytes nullable: false, minSize: 1
        mimeType nullable: false, blank: false, display: false, editable: false
        md5sum nullable: false, blank: false, display: false, editable: false
    }

    String toString(){
        filename ?: "File #$id"
    }

    static mapping = {
        bytes sqlType: 'longblob'
    }

    def beforeValidate() {
        md5sum = bytes.encodeAsMD5()
        try{
            mimeType = Magic.getMagicMatch( bytes ).mimeType
        }catch(e){
            log.error "MagicMatch error", e
        }
    }

    static transients = ['isRenderableImage', 'fileExtension']

    Boolean getIsRenderableImage(){
        mimeType.toLowerCase() in [
            "image/jpeg",
            "image/jpg",
            "image/png",
            "image/gif",
            "image/tif",
            "image/tiff"
        ]
    }

    String getFileExtension(){
        def matcher = filename =~ /\.([^.]+)$/

        if( matcher.size() ){
            matcher.getAt( 0 ).getAt( 1 )
        }
    }

}

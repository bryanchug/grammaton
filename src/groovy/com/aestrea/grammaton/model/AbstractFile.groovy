package com.aestrea.grammaton.model

import net.sf.jmimemagic.Magic

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
        mimeType = Magic.getMagicMatch( bytes ).mimeType
    }

    static transients = ['isImage', 'fileExtension']

    Boolean getIsImage(){
        mimeType.startsWith "image/"
    }

    String getFileExtension(){
        def matcher = filename =~ /\.([^.]+)$/

        if( matcher.size() ){
            matcher.getAt( 0 ).getAt( 1 )
        }
    }

}

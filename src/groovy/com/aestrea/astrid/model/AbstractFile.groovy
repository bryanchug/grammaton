package com.aestrea.astrid.model

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
        filename
    }

    static mapping = {
        bytes sqlType: 'longblob'
    }

    def beforeValidate() {
        md5sum = bytes.encodeAsMD5()
        mimeType = Magic.getMagicMatch( bytes ).mimeType
    }

}

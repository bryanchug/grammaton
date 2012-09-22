package com.aestrea.astrid.model

abstract class AbstractFile {

    String  filename
    byte[]  bytes
    String  contentType
    String  md5sum

    static constraints = {
        filename nullable: true, blank: true, display: false, editable: false
        bytes nullable: false, minSize: 1
        contentType nullable: false, blank: false, display: false, editable: false
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
    }

}

package com.aestrea.grammaton.domain

import com.aestrea.grammaton.model.AbstractFile

class File extends AbstractFile {

    public File( byte[] bytes ){
        this.bytes = bytes
        this.validate()
    }

    public File( String url ){
        this.bytes = url.toURL().bytes
        this.validate()
    }

}

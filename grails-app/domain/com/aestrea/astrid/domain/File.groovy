package com.aestrea.astrid.domain

import com.aestrea.astrid.model.*

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

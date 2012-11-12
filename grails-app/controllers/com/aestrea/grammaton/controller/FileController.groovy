package com.aestrea.grammaton.controller

import com.aestrea.grammaton.domain.File

class FileController {

    def scaffold = File

    def list(){
        response.sendError(404)
    }

    def edit(){
        response.sendError(404)
    }

    def update(){
        response.sendError(404)
    }

    def delete(){
        response.sendError(404)
    }

    def show() {
        def file = File.read( params.id )
        byte[] content = file?.bytes
        if(content){
            cache(store: true, shared: true, neverExpires: true)
            withCacheHeaders {
                etag { "${file.md5sum}" }
                generate {
                    if( file.mimeType.startsWith("image") ){
                        response.contentType = file.mimeType
                    }else{
                        response.contentType = "application/octet-stream"
                        response.setHeader("Content-disposition", "attachment;filename=${file.filename}")
                    }
                    response.outputStream << content
                }
            }
        }
    }

    def save() {

        params.contentType = params.bytes.contentType
        params.filename = params.bytes.originalFilename

        def fileInstance = new File(params)

        if (!fileInstance.save(flush: true)) {
            render(view: "create", model: [fileInstance: fileInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'file.label', default: 'File'), fileInstance.id])
        redirect(action: "create")
    }

}
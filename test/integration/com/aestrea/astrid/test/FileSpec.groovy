package com.aestrea.astrid.test

import com.aestrea.astrid.domain.*
import grails.plugin.spock.IntegrationSpec

class FileSpec extends IntegrationSpec {

    def "Test MagicMime"() {
        when:
        def url = "https://en.gravatar.com/userimage/21130789/16ec4610bc2526d57bb6ca9f0643e127.jpg?size=200"
        def file = new File( url )
        file.validate()

        then:
        file.mimeType == "image/jpeg"
    }

}
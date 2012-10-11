package com.aestrea.grammaton.test

import grails.plugin.spock.IntegrationSpec
import com.aestrea.grammaton.domain.File

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
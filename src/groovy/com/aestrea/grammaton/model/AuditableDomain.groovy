package com.aestrea.grammaton.model

import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils
import grails.plugins.springsecurity.SpringSecurityService
import org.codehaus.groovy.grails.commons.ApplicationHolder

abstract class AuditableDomain {

    Date lastUpdated
    Date dateCreated
    String createdBy
    String updatedBy

    static constraints = {
        createdBy nullable: true
        updatedBy nullable: true
    }

    private static SpringSecurityService getSpringSecurityServiceBean() {
        return ApplicationHolder.application.getMainContext().getBean('springSecurityService')
    }

    private static String getCurrentUsername() {
        getSpringSecurityServiceBean().getPrincipal()?.username
    }

    def beforeUpdate () {
        updatedBy = getCurrentUsername() ?: updatedBy
    }

    def beforeInsert (){
        createdBy = getCurrentUsername() ?: createdBy
        updatedBy = createdBy
    }

}

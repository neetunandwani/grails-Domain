package grails.domain

class Employee {
    String name
    Company company

    static belongsTo = ['company']

    static constraints = {
    }
}

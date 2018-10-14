package grails.domain

class Company {
    String name
    String orgNumber
    List<Employee> employees

    static hasMany = ['employees': Employee]

    static constraints = {
    }
}

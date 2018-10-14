package grails.domain

class Employee {
    String name

//    static belongsTo = [company: Company]       //uncomment this for one to many bidirectional, and to avoid creating third table

    static constraints = {
    }
}

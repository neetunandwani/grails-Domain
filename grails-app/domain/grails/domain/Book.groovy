package grails.domain

class Book {
    String title
    String desc
    Date releaseDate
    Date lastUpdated
    Date dateCreated
    Integer noOfPages

    static belongsTo = [author: Author]

    static constraints = {
        noOfPages max: 100
        title maxSize: 5
    }

    static mapping = {
        table "book_new"
        desc type: "text"
        title column: "name"
        desc column: "description"
    }
}

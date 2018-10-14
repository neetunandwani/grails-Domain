package grails.domain

class Book {
    String title
    String desc
    Date releaseDate
    Date lastUpdated
    Date dateCreated
    Integer noOfPages

//    static hasMany = [authors: Author]
//    static belongsTo = Author

    static constraints = {
        noOfPages max: 100
        title maxSize: 10, unique: true
    }

    static mapping = {
        table "book_new"
        desc type: "text"
        title column: "name"
        desc column: "description"
    }
}

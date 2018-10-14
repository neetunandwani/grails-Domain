import grails.domain.Author
import grails.domain.Book

class BootStrap {

    def init = { servletContext ->
        Book book = new Book(title: "abcde",
            releaseDate: new Date(),
            desc: "cdghsbcdkvd",
            noOfPages: 100)
        book.save(failOnError: true)

        Author author = new Author(firstName: "neetu",
            lastName: "nandwani",
            email: "neetu.nandwani@tothenew.com",
            wiki: "http://www.google.com",
            name: "neetu nandwani",
            address: "sector 127, noida", dob: new Date("11-May-1997"))
        author.save(failOnError: true)

        println("Book: ${book}")
        println("Author: ${author}")
    }
    def destroy = {
    }
}

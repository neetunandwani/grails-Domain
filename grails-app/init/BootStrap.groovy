import grails.domain.Author
import grails.domain.Book
import grails.domain.Company
import grails.domain.Employee

class BootStrap {

    def init = { servletContext ->
//        validationAndMapping()
//        oneToOneMapping()
//        hasOneMapping()
    }

    static void hasOneMapping() {
        Author author = new Author(firstName: "neetu",
            lastName: "nandwani",
            email: "neetu.nandwani@tothenew.com",
            wiki: "http://www.google.com",
            name: "neetu nandwani",
            address: "sector 127, noida", dob: new Date("11-May-1997"))

        Book book = new Book(title: "abcde",
            releaseDate: new Date(),
            desc: "cdghsbcdkvd",
            noOfPages: 100)
        author.book=book
        author.save()
        //bidirectional provide cascade delete, author deletion will delete all its references first
        author.delete()
    }

    static void oneToOneMapping() {
        Author author = new Author(firstName: "neetu",
            lastName: "nandwani",
            email: "neetu.nandwani@tothenew.com",
            wiki: "http://www.google.com",
            name: "neetu nandwani",
            address: "sector 127, noida", dob: new Date("11-May-1997"))

        Book book = new Book(title: "abcde",
            releaseDate: new Date(),
            desc: "cdghsbcdkvd",
            noOfPages: 100)
        //cant save book without author
        book.author = author
        //no need to save author separately
        book.save()

        //cant delete author if relates to book, belongs to does not provide cascade deletion
        book.delete()
        author.delete()
    }

    def destroy = {
    }

    static void validationAndMapping() {
        Book book = new Book(title: "abcde",
            releaseDate: new Date(),
            desc: "cdghsbcdkvd",
            noOfPages: 100)
        book.save()

        Author author = new Author(firstName: "neetu",
            lastName: "nandwani",
            email: "neetu.nandwani@tothenew.com",
            wiki: "http://www.google.com",
            name: "neetu nandwani",
            address: "sector 127, noida", dob: new Date("11-May-1997"))
        author.save()

        println("Book: ${book}")
        println("Author: ${author}")
    }
}

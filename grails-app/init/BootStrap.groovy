import grails.domain.Author
import grails.domain.Book
import grails.domain.Company
import grails.domain.Employee

class BootStrap {

    def init = { servletContext ->
        validationAndMapping()
        oneToOneMapping()
    }

    static void oneToOneMapping() {
        Company company = new Company(name: "ToTheNew", orgNumber: "7878766755")
        company.save()

        Employee employee = new Employee(name: 'Neetu')
        //can't save without company
        employee.company=company
        employee.save()
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

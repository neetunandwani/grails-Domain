import grails.domain.Author
import grails.domain.Book
import grails.domain.Company
import grails.domain.Employee
import grails.domain.Face
import grails.domain.Nose

class BootStrap {

    def init = { servletContext ->
//        validationAndMapping()
//        oneToOneMapping()
//        hasOneMappingBidirectional()
//        oneToManyMapping()
//        oneToManyMappingBidirectional()
//        manyToManyMapping()
    }

    static void manyToManyMapping() {
        //uncomment has many and belongs to
        List<Book> bookList = []
        6.times {
            bookList.add(new Book(title: "Title_${it}",
                releaseDate: new Date(),
                desc: "cdghsbcdkvd",
                noOfPages: 100))
        }

        Author author1 = new Author(firstName: "neetu",
            lastName: "nandwani",
            email: "neetu.nandwani@tothenew.com",
            wiki: "http://www.google.com",
            name: "neetu nandwani",
            address: "sector 127, noida", dob: new Date("11-May-1997"))
        Author author2 = new Author(firstName: "neetu",
            lastName: "nandwani",
            email: "neetu.nandwani+1@tothenew.com",
            wiki: "http://www.google.com",
            name: "neetu nandwani",
            address: "sector 127, noida", dob: new Date("11-May-1997"))
        Author author3 = new Author(firstName: "neetu",
            lastName: "nandwani",
            email: "neetu.nandwani+2@tothenew.com",
            wiki: "http://www.google.com",
            name: "neetu nandwani",
            address: "sector 127, noida", dob: new Date("11-May-1997"))
        Author author4 = new Author(firstName: "neetu",
            lastName: "nandwani",
            email: "neetu.nandwani+3@tothenew.com",
            wiki: "http://www.google.com",
            name: "neetu nandwani",
            address: "sector 127, noida", dob: new Date("11-May-1997"))
        author1.addToBooks(bookList.get(0))
        author1.addToBooks(bookList.get(1))
        author1.save()

        author2.addToBooks(bookList.get(1))
        author2.addToBooks(bookList.get(2))
        author2.save()

        author3.addToBooks(bookList.get(3))
        author3.addToBooks(bookList.get(4))
        author3.save()
        author4.save()

        //only book will get saved
        bookList.get(5).authors = []
        bookList.get(5).authors.add(author4)
        bookList.get(5).save()

        //delete if not referred in author
        Book.get(6).delete()

        //will also delete from third table
        Author.get(1).delete()
    }

    static void oneToManyMappingBidirectional() {
        //uncomment belongs to
        Company company = new Company(name: "ToTheNew", orgNumber: "7878766755")
        Employee employee = new Employee(name: 'Neetu')
        Employee employee1 = new Employee(name: 'abc')
        company.addToEmployees(employee)
        company.addToEmployees(employee1)
        company.save()
        //cascade will work
        company.delete()
    }

    static void oneToManyMapping() {
        Company company = new Company(name: "ToTheNew", orgNumber: "7878766755")
        Employee employee = new Employee(name: 'Neetu')
        Employee employee1 = new Employee(name: 'abc')
        company.addToEmployees(employee) //without has many wont get this feature
        company.addToEmployees(employee1)
        company.save()
        company.delete()
        //cascade delete wont work
//        employee.delete()
    }

    static void hasOneMappingBidirectional() {
        //uncomment belongs to and has many
        Face face = new Face()
        Nose nose = new Nose()
        face.nose = nose
        face.save()
        //cascade will work
        face.delete()
    }

    static void oneToOneMapping() {
        Face face = new Face()
        Nose nose = new Nose()
        face.nose = nose
        face.save()
        //cascade delete wont work
        face.delete()
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

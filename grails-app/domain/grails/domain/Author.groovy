package grails.domain

class Author {
    String firstName
    String lastName
    String email
    String address
    String wiki
    String name

    static transients = ['name']

    static constraints = {
        address type: 'text'
        email email: true
        firstName bindable: false
        lastName bindable: false
        wiki url: true
    }

    String getName() {
        return firstName + " " + lastName
    }

    void setName(String name) {
        firstName = name.split(" ").first()
        lastName = name.split(" ").last()
    }
}

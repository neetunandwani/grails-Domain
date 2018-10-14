package grails.domain

class Author {
    String firstName
    String lastName
    String email
    String address
    String wiki
    String name
    Date dob
    Integer age

//    static hasMany = [books: Book]

    static transients = ['name', 'age']

    static constraints = {
        address type: 'text', blank: false
        email email: true, unique: true
        firstName bindable: false
        lastName bindable: false
        wiki url: true
        age validator: { val, obj ->
            if (val < 10) {
                return false
            }
        }
    }

    String getName() {
        return firstName + " " + lastName
    }

    void setName(String name) {
        firstName = name.split(" ").first()
        lastName = name.split(" ").last()
    }

    Integer getAge() {
        Map diff = dob ? getDiffInDates(dob, new Date()) : [:]
        return diff.years
    }


    public static Map getDiffInDates(Date oldDate, Date newDate = new Date()) {
        Long difference = newDate.time - oldDate.time
        Map diffMap = [:]
        difference = difference / 1000
        diffMap.seconds = difference % 60
        difference = (difference - diffMap.seconds) / 60
        diffMap.minutes = difference % 60
        difference = (difference - diffMap.minutes) / 60
        diffMap.hours = difference % 24
        difference = (difference - diffMap.hours) / 24
        diffMap.years = (difference / 365).toInteger()
        if (diffMap.years)
            difference = (difference) % 365
        diffMap.days = difference % 7
        diffMap.weeks = (difference - diffMap.days) / 7
        return diffMap
    }


    @Override
    public String toString() {
        return "Author{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            '}';
    }
}

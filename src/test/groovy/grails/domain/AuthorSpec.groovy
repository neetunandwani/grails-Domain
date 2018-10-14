package grails.domain

import grails.test.mixin.TestFor
import grails.test.mixin.domain.DomainClassUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Author)
class AuthorSpec extends Specification {

    void 'test address cannot be null or blank'() {
        when:
        Author author = new Author()

        then:
        !author.validate(['address'])
        author.errors['address'].code == 'nullable'

        when:
        author.address = ""

        then:
        !author.validate(['address'])
        author.errors['address'].code == 'blank'
    }

    void 'test email not valid'() {
        when:
        Author author = new Author(email: "ab")

        then:
        !author.validate(['email'])
        author.errors['email'].code == 'email.invalid'
    }

    void 'test age custom validator'() {
        when:
        Author author = new Author(dob: new Date("11-Feb-2016"))

        then:
        !author.validate(['age'])
        author.errors['age'].code == 'validator.invalid'
    }
}

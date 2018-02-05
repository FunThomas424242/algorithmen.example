package gh.funthomas424242.pattern.builder;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PersonBuilder {

    Person person;

    PersonBuilder(){
        this.person=new Person();
    }

    public PersonBuilder withName(final String name){
        this.person.name=name;
        return this;
    }

    public PersonBuilder withVorname(final String vorname){
        this.person.vorname=vorname;
        return this;
    }

    public PersonBuilder withBirthday(final int tag, final int monat, final int jahr){
        this.person.birthday = new Date(jahr,monat,tag);
        return this;
    }

    public Person build(){
        final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        final Set<ConstraintViolation<Person>> constraintViolations = validator.validate(this.person);

        if (constraintViolations.size() > 0) {
            Set<String> violationMessages = new HashSet<String>();

            for (ConstraintViolation<?> constraintViolation : constraintViolations) {
                violationMessages.add(constraintViolation.getPropertyPath() + ": " + constraintViolation.getMessage());
            }

            throw new ValidationException("Person is not valid:\n" + StringUtils.join(violationMessages, "\n"));
        }
        final Person p=this.person;
        this.person=null;
        return p;
    }


}

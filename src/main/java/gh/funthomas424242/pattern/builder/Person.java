package gh.funthomas424242.pattern.builder;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Person {

    @Size(min=1, max=20)
    protected String name;

    protected String vorname;

    @NotNull
    protected Date birthday;

    public Person() {
    }


    static class Accessor{
        final protected Person person;

        public Accessor(final Person person){
            this.person=person;
        }

        public String getName(){
            return this.person.name;
        }

        public String getVorname(){
            return this.person.vorname;
        }

        public Date getBirthday(){
            return this.person.birthday;
        }

    }

    static class Builder {

        Person person;

        Builder(){
            this.person=new Person();
        }

        public Builder withName(final String name){
            this.person.name=name;
            return this;
        }

        public Builder withVorname(final String vorname){
            this.person.vorname=vorname;
            return this;
        }

        public Builder withBirthday(final int tag, final int monat, final int jahr){
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

}

package gh.funthomas424242.pattern.builder;

import java.util.Date;

public class Person {

    protected String name;

    protected String vorname;

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
            final Person p=this.person;
            this.person=null;
            return p;
        }


    }

}

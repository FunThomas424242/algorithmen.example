package gh.funthomas424242.pattern.builder;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void erzeugeValidePersonenInstanz(){
        final Person person = new Person.Builder().withBirthday(8,11,1990).build();
        assertNotNull(person);
    }

    @Test
    public void erzeugeAccessorWithValidPerson(){
        final Person person = new Person.Builder()
                .withBirthday(8,11,1990)
                .withName("Michel")
                .build();
        final Person.Accessor accessor = new Person.Accessor(person);
        assertNotNull(accessor);
        assertEquals("Michel",accessor.getName());
        assertNull(accessor.getVorname());
    }

}
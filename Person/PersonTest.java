import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

/**
 * The test class PersonTest.
 *
 * @author Paula Díaz Álvarez
 * @version 30/09/2022
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonTest
{
    /**
     * Default constructor for test class PersonTest
     */
    public PersonTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown() {
    }
    
    //CONSTRUCTORS
    /*
     * @Test
    public void constructor1Basic() { //Previous default constructor with default values
        Person dummy= new Person();
        assertEquals(dummy.getName(),"Paula");
        assertEquals(dummy.getSurname(),"Díaz");
        assertEquals(dummy.getAge(),Person.MIN_AGE_VALUE);
        assertEquals(dummy.getGender(),Person.FEMALE_VALUE);
    }
    */
    /**
     * Test for the constructor: Person(int age)
     */
    @Test    
    public void constructor2Basic() {
        Person dummy= new Person(Person.MIN_AGE_VALUE+1);
        assertEquals(dummy.getAge(),Person.MIN_AGE_VALUE+1);
        //assertEquals(dummy.getName(),"Paula");
        //assertEquals(dummy.getSurname(),"Díaz");
        //assertEquals(dummy.getGender(),Person.FEMALE_VALUE);
        
        Person dummy2=new Person(Person.MIN_AGE_VALUE);
        assertEquals(dummy2.getAge(),Person.MIN_AGE_VALUE);
    }
    /**
     * Test for the constructor: Person(String name, String surname)
     */
    @Test
    public void constructor3Basic() {
        Person dummy= new Person("AB","CD");
        assertEquals(dummy.getName(),"AB");
        assertEquals(dummy.getSurname(),"CD");
        //assertEquals(dummy.getAge(),Person.MIN_AGE_VALUE);
        //assertEquals(dummy.getGender(),Person.FEMALE_VALUE);
        
        Person dummy2= new Person("CD","AB");
        assertEquals(dummy2.getName(),"CD");
        assertEquals(dummy2.getSurname(),"AB");
    }
    /**
     * Test for the constructor: Person(String name, String surname, int age, boolean gender)
     */
    @Test
    public void constructor4Basic() {
        Person dummy= new Person("AB","CD",Person.MIN_AGE_VALUE+1,Person.MALE_VALUE);
        assertEquals(dummy.getName(),"AB");
        assertEquals(dummy.getSurname(),"CD");
        assertEquals(dummy.getAge(),Person.MIN_AGE_VALUE+1);
        assertEquals(dummy.getGender(),Person.MALE_VALUE);
        
        Person dummy2= new Person("CD","AB",Person.MIN_AGE_VALUE,Person.FEMALE_VALUE);
        assertEquals(dummy2.getName(),"CD");
        assertEquals(dummy2.getSurname(),"AB");
        assertEquals(dummy2.getAge(),Person.MIN_AGE_VALUE);
        assertEquals(dummy2.getGender(),Person.FEMALE_VALUE);
    }
    
    
    //SETTERS AND GETTERS
    /**
     * Test for the method: setName (String name)
     */
    @Test
    public void nameBasic() {
        Person dummy= new Person();
        dummy.setName("Paco");
        assertEquals(dummy.getName(),"Paco");
        
        dummy.setName("Raquel");
        assertEquals(dummy.getName(),"Raquel");
    }
    /**
     * Test for the method: setName (String name) with special chars such as @, ""..
     */
    @Test
    public void nameSpecialChars() {
        Person dummy= new Person();
        dummy.setName("@");
        assertEquals(dummy.getName(),"@");
        
        dummy.setName("");
        assertEquals(dummy.getName(),"");
    }
    
    /**
     * Test for the method: setSurname (String surname)
     */
    @Test
    public void surnameBasic() {
        Person dummy= new Person();
        dummy.setSurname("Madrigal");
        assertEquals(dummy.getSurname(),"Madrigal");
        
        dummy.setSurname("Lorenzo");
        assertEquals(dummy.getSurname(),"Lorenzo");
    }
    /**
     * Test for the method: setSurname (String surname) with special chars such as @, ""..
     */
    @Test
    public void surnameSpecialChars() {
        Person dummy= new Person();
        dummy.setSurname("@");
        assertEquals(dummy.getSurname(),"@");
        
        dummy.setSurname("");
        assertEquals(dummy.getSurname(),"");
    }
    
    /**
     * Test for the method: setAge (int age)
     */
    @Test
    public void ageBasic() {
        Person dummy= new Person();
        //Positive test
        dummy.setAge(Person.MIN_AGE_VALUE); //age=0
        assertEquals(dummy.getAge(),Person.MIN_AGE_VALUE);
        
        dummy.setAge((Person.MIN_AGE_VALUE+Person.MAX_AGE_VALUE)/2); //age=59
        assertEquals(dummy.getAge(),(Person.MIN_AGE_VALUE+Person.MAX_AGE_VALUE)/2); 
        
        dummy.setAge(Person.MAX_AGE_VALUE); //age=118
        assertEquals(dummy.getAge(),Person.MAX_AGE_VALUE);
        
        //Negative test
        dummy.setAge(Person.MIN_AGE_VALUE); //age=0    
        try { //age=-1
          dummy.setAge((Person.MIN_AGE_VALUE)-1);
          fail ();
        }
        catch (Exception e) {
          assertEquals(dummy.getAge(),Person.MIN_AGE_VALUE); //the age hasn't been updated
          assertEquals(e.getMessage(),Person.ERROR_LOWER_AGE); //the correct error message has been thrown
        }
        
        try { //age=-118
          dummy.setAge(-(Person.MAX_AGE_VALUE));
          fail ();
        }
        catch (Exception e) {
          assertEquals(dummy.getAge(),Person.MIN_AGE_VALUE);
          assertEquals(e.getMessage(),Person.ERROR_LOWER_AGE);
        }
        
        try { //age=119
          dummy.setAge((Person.MAX_AGE_VALUE)+1);
          fail ();
        }
        catch (Exception e) {
          assertEquals(dummy.getAge(),Person.MIN_AGE_VALUE);
          assertEquals(e.getMessage(),Person.ERROR_HIGHER_AGE);
        }
        
        try { //Age=236
          dummy.setAge(2*(Person.MAX_AGE_VALUE));
          fail ();
        }
        catch (Exception e) {
          assertEquals(dummy.getAge(),Person.MIN_AGE_VALUE);
          assertEquals(e.getMessage(),Person.ERROR_HIGHER_AGE);
        }
    }
    /**
     * Test for the method: getCriticalAge()
     */
    @Test
    public void criticalAgeBasic() {
        Person dummy= new Person();
        
        dummy.setAge((Person.ADULTHOOD_AGE)-1); //1 year before adulthood
        assertEquals(dummy.getCriticalAge(),1); //1 year until adulthood
        
        dummy.setAge(Person.ADULTHOOD_AGE); //Adulthood
        assertEquals(dummy.getCriticalAge(),Person.RETIREMENT_AGE-Person.ADULTHOOD_AGE); //years until retirement
        
        dummy.setAge((Person.RETIREMENT_AGE)-1); //1 year before retirement
        assertEquals(dummy.getCriticalAge(),1);
        
        dummy.setAge(Person.RETIREMENT_AGE); //Retirement
        assertEquals(dummy.getCriticalAge(),0);
        
        dummy.setAge((Person.RETIREMENT_AGE)+1); //1 year after retirement
        assertEquals(dummy.getCriticalAge(),1);
    }
    
    /**
     * Test for the method: setGender (boolean gender)
     */
    @Test
    public void genderBasic() {
        Person dummy= new Person();
        dummy.setGender(true);
        assertEquals(dummy.getGender(),true);
        
        dummy.setGender(false);
        assertEquals(dummy.getGender(),false);
    }
    /**
     * Test for the method: isAGirl()
     */
    @Test
    public void isAGirlBasic() {
        Person dummy= new Person();
        dummy.setGender(Person.FEMALE_VALUE);
        assertEquals(dummy.isAGirl(),true);
        
        dummy.setGender(Person.MALE_VALUE);
        assertEquals(dummy.isAGirl(),false);
    }
    
    //PRINTING DATA
    /**
     * Test for the method: toString()
     */
    @Test
    public void toStringBasic() {
        Person dummy= new Person("a","b",Person.MIN_AGE_VALUE,Person.FEMALE_VALUE);
        
        assertEquals(dummy.toString(),"[Name: a - Surname: b - Age: "+Person.MIN_AGE_VALUE+" - Gender: female]");
        
        dummy.setName("c");
        dummy.setSurname("d");
        dummy.setAge(Person.MAX_AGE_VALUE);
        dummy.setGender(Person.MALE_VALUE);
        assertEquals(dummy.toString(),"[Name: c - Surname: d - Age: "+Person.MAX_AGE_VALUE+" - Gender: male]");
    }
    
    /**
     * Test for the method: getHashCode ()
     */
    @Test
    public void getHashCodeBasic() {
        Person dummy= new Person("a","b",Person.MIN_AGE_VALUE,false);
        assertEquals(dummy.getHashCode(),"A-B-"+Person.MIN_AGE_VALUE+"-false");
        
        Person dummy2= new Person("c","d",Person.MAX_AGE_VALUE,true);
        assertEquals(dummy2.getHashCode(),"C-D-"+Person.MAX_AGE_VALUE+"-true");
    }
    /**
     * Test for the method: HashCode ()
     */
    @Test
    public void HashCodeBasic() {
        Person dummy= new Person("abcd","efgh",Person.MAX_AGE_VALUE,false);
        assertEquals(dummy.HashCode(),"ABC-EFG-"+Person.MAX_AGE_VALUE+"-false");
        
        Person dummy2= new Person("ijkl","mnop",Person.MIN_AGE_VALUE,true);
        assertEquals(dummy2.HashCode(),"IJK-MNO-"+Person.MIN_AGE_VALUE+"-true");
    }
        
    //COMPARISONS
    /**
     * Test for the method:areYou(int age)
     */
    @Test
    public void areYouAgeBasic() {
        Person dummy= new Person(Person.MIN_AGE_VALUE);
                
        assertEquals(dummy.areYou(Person.MIN_AGE_VALUE),true);
        assertEquals(dummy.areYou(Person.MAX_AGE_VALUE),false);
        
        dummy.setAge(Person.MAX_AGE_VALUE);
        assertEquals(dummy.areYou(Person.MAX_AGE_VALUE),true);
        assertEquals(dummy.areYou(Person.MIN_AGE_VALUE),false);
    }
    
    /**
     * Test for the method: areYou(String name)
     */
    @Test
    public void areYouNameBasic() {
        Person dummy= new Person("Hamilton","Díaz");
        
        assertEquals(dummy.areYou("Hamilton"),true);
        assertEquals(dummy.areYou("Neal"),false);
        assertEquals(dummy.areYou("HAMILTON"),true);
        
        dummy.setName("Neal");
        assertEquals(dummy.areYou("Neal"),true);
        assertEquals(dummy.areYou("Hamilton"),false);
        assertEquals(dummy.areYou("NEAL"),true);
    }
    
    /**
     * Test for the method: areYou(Person person)
     */
    @Test
    public void areYouPersonBasic() {
        Person a = new Person("Neal","Armstrong",Person.MAX_AGE_VALUE,Person.MALE_VALUE);
        Person b = new Person("Valentina","Tereshkova",Person.MAX_AGE_VALUE,Person.FEMALE_VALUE);
        
        assertEquals(a.areYou(b),false); //comparing person a with b
        assertEquals(a.areYou(a),true);  //comparing person a with a
        assertEquals(b.areYou(b),true);  //comparing person b with b
        
        a.setName("Valentina");
        a.setSurname("Tereshkova");
        a.setGender(Person.FEMALE_VALUE);
        
        assertEquals(a.areYou(b),true);
        assertEquals(a.areYou(a),true);
        assertEquals(b.areYou(a),true);
    }
    
    /**
     * Test for the method: compareTo(Person person)
     */
    @Test
    public void compareToBasic() {
        Person a = new Person("Neal","Armstrong",Person.MAX_AGE_VALUE-1,Person.MALE_VALUE);
        Person b = new Person("Valentina","Tereshkova",Person.MAX_AGE_VALUE-1,Person.FEMALE_VALUE);
        //Same age        
        assertEquals(a.compareTo(b),0);
        assertEquals(a.compareTo(a),0);
        assertEquals(b.compareTo(b),0);
        
        b.setAge(Person.MAX_AGE_VALUE); //b has a higher age
            
        assertEquals(a.compareTo(b),-1);
        assertEquals(a.compareTo(a),0);
        assertEquals(b.compareTo(b),0);
        
        b.setAge(Person.MIN_AGE_VALUE); //b has a lower age
            
        assertEquals(a.compareTo(b),1);
        assertEquals(a.compareTo(a),0);
        assertEquals(b.compareTo(b),0);
    }
}

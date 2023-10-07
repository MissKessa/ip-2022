
/**
 * Test the methods in the Person class
 * 
 * @author Paula Díaz Álvarez 
 * @version 30/9/2022
 */
public class Test
{
    
    /**
     * Constructor for objects of class Test
     */
    public Test() {
        
    }

    /**
     * Test for the method: setGender(boolean gender)
     * @return True if all the tests passed. Returns false if one of the test failed.
     */
    private boolean testGender() {
        Person dummy = new Person();
        dummy.setGender (true);
        
        if (dummy.getGender()!=true) {
            System.out.println ("BUG at test for True");
            return false; //bug detected!!!
        }
        
        dummy.setGender(false);
        if (dummy.getGender()!=false) {
            System.out.println ("BUG at test for False");
            return false; //bug detected!!!
        }
        
        return true; //all the tests passed        
    }
    
    /**
     * Test for the method: isAGirl()
     * @return True if all the tests passed. Returns false if one of the test failed.
     */
    private boolean testIsAGirl () {
        Person dummy = new Person();
        dummy.setGender (Person.FEMALE_VALUE);
        
        if (dummy.isAGirl()==false) {
            System.out.println ("BUG at test for FEMALE");
            return false; //bug detected!!!
        }
        dummy.setGender (Person.MALE_VALUE);
        if (dummy.isAGirl()==true) {
            System.out.println ("BUG at test for MALE");
            return false; //bug detected!!!
        }
        
        return true;
    }
    
    /**
     * Tests the all the tests of this class
     * @return True if all the tests passed. Returns false if one of the test failed.
     */
    public boolean testAll () {
        return testGender() && testIsAGirl();
            
            /*
            if (testGender()==true && testIsAGirl()==true)
               return true;
            else
                return false;
           */
    }
}

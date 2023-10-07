import java.util.Random;

/**
 * This class creates a Person and you can change their name, surname, age and gender; print their content; compare it with other
 * people....
 *
 * @author Paula Díaz Álvarez
 * @version 13/09/2022
 */
public class Person
{
    //Constants
    /**
     * It's the representation of the female value for the gender
     */
    public final static boolean FEMALE_VALUE = true;
    /**
     * It's the representation of the male value for the gender
     */
    public final static boolean MALE_VALUE = false;
    /**
     * It's the lower limit for the age (it's also a valid age)
     */
    public final static int MIN_AGE_VALUE = 0;
    /**
     * It's the upper limit for the age (it's also a valid age)
     */
    public final static int MAX_AGE_VALUE = 118;
    /**
     * It's the value for the adulthood age
     */
    public final static int ADULTHOOD_AGE = 18;
    /**
     * It's the value for the retirement age
     */
    public final static int RETIREMENT_AGE = 61;
    //Error messages
    /**
     * It's the error message thrown when the age is less than the MIN_AGE_VALUE
     */
    public final static String ERROR_LOWER_AGE="The age must be higher than or equal to "+ MIN_AGE_VALUE;
    /**
     * It's the error message thrown when the age is greater than the MAX_AGE_VALUE
     */
    public final static String ERROR_HIGHER_AGE="The age must be less than or equal to "+ MAX_AGE_VALUE;
    //names and surnames
    /**
     * It's a list of different male names
     */
    public final static String MALE_NAMES[]={"Martín","Ricardo","Toni","Luis","Paco"};
    /**
     * It's a list of different female names
     */
    public final static String FEMALE_NAMES[]={"Paula","Ana","María","Raquel","Rosa"};
    /**
     * It's a list of different surnames
     */
    public final static String SURNAMES[]={"Díaz","Castro","Pérez","Suarez","Álvarez"};
    //Attributes
    private String name;
    private String surname;
    private int age;
    private boolean gender;
    
    //CONSTRUCTORS
    /**
     * Default constructor to create a person with random values. 
     * It assigns a random name (if it is a male "Yuri" and if it's a female "Valentina"), random surname, random age between 
     * [MIN_AGE_VALUE,MAX_AGE_VALUE], and a random gender
     */
    public Person() {
       System.out.println ("Random constructor of Person invoked");
       Random coin= new Random(); 
       
       setAge(coin.nextInt(MAX_AGE_VALUE+1 - MIN_AGE_VALUE) + MIN_AGE_VALUE);
       setGender(coin.nextBoolean());
       if (gender==FEMALE_VALUE){
           setName(FEMALE_NAMES[coin.nextInt(FEMALE_NAMES.length)]);
       }
       else {
           setName(MALE_NAMES[coin.nextInt(MALE_NAMES.length)]);
       }
       setSurname(SURNAMES[coin.nextInt(SURNAMES.length)]);
    }

    /**
     * Constructor to create a person with a given age and the rest of the fields are random as the default constructor
     * @param age It's the age that is set to the person
     */
    public Person(int age) {
       this();
       System.out.println ("Constructor 2 of Person invoked");
       setAge(age);
    }
    
    /**
     * Constructor to create a person with a given a name and a given surname. The rest of the fields are random as the default
     * constructor
     * @param name It's the name that is set to the person
     * @param surname It's the surname that is set to the person
     */
    public Person(String name, String surname) {
       this();
       System.out.println ("Constructor 3 of Person invoked");
       setName(name);
       setSurname(surname);
    }
    
    /**
     * Constructor to create a person with a given a name, a given surname, a given age and a given gender.
     * @param name It's the name that is set to the person
     * @param surname It's the surname that is set to the person
     * @param age It's the age that is set to the person
     * @param gender It's the gender that is set to the person
     */
    public Person(String name, String surname, int age, boolean gender) {
       System.out.println ("Constructor 4 of Person invoked");
       setName(name);
       setSurname(surname);
       setAge(age);
       setGender(gender);
    }
    
    //EXCEPTIONS
    /**
     * Throws a given error message if the given condition is not true
     * @param condition It's the condition that is going to be checked
     * @param message It's the error message that is thrown if the condition is not true
     */
    private void checkParam (boolean condition, String message) {
        if (!condition)
            throw new RuntimeException (message);
    }
    
    //SETTERS AND GETTERS
    /**
     * Changes the value of the name of the person
     * @param name It's the name that is set to the person
     */
    public void setName (String name) {
        this.name = name; 
    }
    /**
     * Returns the value of the name of the person
     * @return The current value of the name of the person
     */
    public String getName () {
        return name;
    }
        
    /**
     * Changes the value of the surname of the person
     * @param surname It's the surname that is set to the person
     */
    public void setSurname (String surname) {
        this.surname = surname;
    }
    /**
     * Returns the value of the surname of the person
     * @return The current value of the surname of the person
     */
    public String getSurname () {
        return surname;
    }
              
    /**
     * Changes the value of the age of the person.
     * If the new value for the age is less than MIN_AGE_VALUE or higher than MAX_AGE_VALUE, the age will not be updated and an
     * error message will appear depending on the error.
     * @param age It's the age that is set to the person
     */
    public void setAge (int age) {
        checkParam(age >= MIN_AGE_VALUE, ERROR_LOWER_AGE);
        checkParam(age <= MAX_AGE_VALUE, ERROR_HIGHER_AGE);
        this.age = age;
    }
    /**
     * Returns the value of the age of the person
     * @return The current value of the age of the person
     */
    public int getAge () {
        return age;
    }
    
    /**
     * Returns how many years are:
     * -until adulthood if age<ADULTHOOD_AGE
     * -until retirement if  age>=ADULTHOOD_AGE and age<RETIREMENT_AGE
     * -after retirement if age>=RETIREMENT_AGE
     * @return The years until adulthood, until retirement or after retirement.
     */
    public int getCriticalAge() {
       int criticalAge=0;
        if (age>=ADULTHOOD_AGE)
           if (age>=RETIREMENT_AGE) {
               criticalAge=age-RETIREMENT_AGE;
           }
           else { 
               criticalAge=RETIREMENT_AGE-age;
           }
       else {
           criticalAge=ADULTHOOD_AGE-age;
       }
       return(criticalAge);
    }
    
    
    /**
     * Changes the value of the gender of the person
     * @param gender It's the age that is set to the person
     */
    public void setGender (boolean gender) {
        this.gender = gender; 
    }
    /**
     * Returns the value of the gender  of the person
     * @return The current value of the gender of the person
     */
    public boolean getGender () {
        return gender;
    }
    
     /**
     * Asks if the person is a girl. If gender is female, it's a girl. Else, it's a boy (not a girl)
     * @return True if the gender of the person is female
     */
    public boolean isAGirl() {
        if (gender == FEMALE_VALUE)
            return true; //She is a girl
        else //He is a boy
            return false;
    }
    /**
     * Transform the boolean gender into a word ("Male"|"Female").
     * @return The corresponding word of the gender field ("Male"|"Female").
     */
    private String genderToString() {
        if (isAGirl())
            return "female";
        else
            return "male";
    }
        
    //PRINTING DATA
    /**
     * Prints the contents of name,surname, age and gender of the person into the computer's console (display).
     * If the gender is equal to FEMALE_VALUE, it prints female. If not, it prints male
     */
    public void print1() {
        System.out.println("Name: "+ name);
        System.out.println("Surname: "+ surname);
        System.out.println("Age: "+ age);
               
        if (!isAGirl())
           System.out.println("Gender: male");
        else
           System.out.println("Gender: female");
    }
    /**
     * Prints the value of name,surname, age and gender of the person into the computer's console (display).
     * If the gender is equal to FEMALE_VALUE, it prints female. If not, it prints male
     */
    public void print2() {
        System.out.println("Name: "+ name);
        System.out.println("Surname: "+ surname);
        System.out.println("Age: "+ age);
        System.out.print("Gender: "+ genderToString());
    }
    
    /**
     * Returns a line that contains the value of name, surname, age and gender of the person. If the gender is equal to
     * FEMALE_VALUE, it prints female. If not, it prints male
     * @return Line corresponding to all the values of the fields of the person
     */
    public String toString () {
       String result = "[Name: "+ name; 
       
       result += " - Surname: "+ surname;
       result += " - Age: "+ age;
       result += " - Gender: "+ genderToString () + "]";
       
      return result;
    }
    
    /**
     * Returns a line looking like a code, including the value of name, surname, age and gender of the person.
     * The name and the surname are written in Upper Case.
     * @return Line looking like a code representing the values of the fields of the class
     */
    public String getHashCode () {
       String result = ""; 
       
       result += name.toUpperCase();
       result += "-" + surname.toUpperCase();
       result += "-" + age;
       result += "-"+ gender;
       
       return result;
    }
    /**
     * Creates a line looking like a code, including the value of name, surname, age and gender of the person.
     * It only writes the first 3 letters of the name and the surname in Upper Case.
     * @return Line looking like a code representing the values of the fields of the class
     */
    public String HashCode () {
       String result = ""; 
       
       result += name.substring (0,3).toUpperCase();
       result += "-" + surname.substring (0,3).toUpperCase();
       result += "-" + age;
       result += "-"+ gender;
       
       return result;
    }
    
    //COMPARISONS
    /**
     * Compares the age of the person with a given age.
     * @param age It's the given age that is been compared with the age of the person
     * @return True if the given age and the age of the person are the same.
     */
    public boolean areYou(int age) {
        /*
        if (this.age == age)
            return true;
        else
            return false;
        */
       return this.age == age;
    }
    
    /**
     * Compares the name of the person with a given name.
     * @param name It's the given name that is been compared with the name of the person
     * @return True if the given name and the name of the person are the same (ignoring the case).
     */
    public boolean areYou(String name) {
      return this.name.equalsIgnoreCase(name);
      /*
       * return this.namecompareToIgnoreCase(name)==0
       */
    }
    
    /**
     * Compares all the fields of the object with a given object.
     * @param Person is the given object
     * @return boolean true if the given object and the object are the same (have the same values for the fields). Returns
     * false if they are different.
     */
    public boolean areYou(Person person) {
       return areYou(person.getName())&&
       this.surname.equalsIgnoreCase(person.getSurname()) &&
       areYou(person.getAge())&&
       this.gender==person.getGender();
       //You can also use: this.name.equalsIgnoreCase(person.getName()), this.age==person.getAge()
    }
    
    /**
     * Compares the age of the object with a given one.
     * @param Person is the given object
     * @return 0 if the age is the same. Returns 1 if the age of the object is greater than the given one, and -1 if the
     * age of the object is less than the given one
     */
    public int compareTo(Person person) {
       if (getAge()!=person.getAge())
           if (getAge()>person.getAge())
               return 1;
            else
                return -1;
        else
            return 0; //the age is the same
        /*
         * if (getAge()==person.getAge())
         *  return 0;
         * else
         *  if (getAge()<person.getAge())
         *   return -1;
         *  else
         *   return 1;
         */
    }
}

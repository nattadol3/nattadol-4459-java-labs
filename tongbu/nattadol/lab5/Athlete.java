/**
 * This is the Athlete class.  It contains the values of name, weight, height, gender, nationality, and birthdate of the athlete.
 * Author: Nattadol Thongbu
 * Date: 1/17/2023
 * ID: 653040445-9
 * Sec: 2
 **/

package tongbu.nattadol.lab5;

// Import LocalDate and DateTimeFormatter to use for ahtlete birthdate and  ChronoUnit to compare the age of athletes
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Athlete {
    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    protected String name;
    protected double weight;
    protected double height;

    // Gender enum.  Contains the gender of the athlete which is MALE and FEMALE
    protected enum Gender {
        MALE,
        FEMALE
    }

    protected Gender gender;
    protected String nationality;
    protected LocalDate birthDate;

    //Constructor of Athlete class.  need name, weight, height, gender, nationality, and birth date of the athlete.
    public Athlete(String name, double weight, double height, Gender gender,  String nationality, String birthDate) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.nationality = nationality;
        this.birthDate = LocalDate.parse(birthDate, formatter);
    }

    // These are the setter, getter method of all the attributes.
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = LocalDate.parse(birthDate, formatter);
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    // compareAge() method.  Need to pass in another Athlete object as a parameter.  Used ChronoUnit to compare the year of birth and display
    // if the second ahtlete is older or yonger than the first athlete.
    public void compareAge(Athlete secondAthlete) {
        long year = ChronoUnit.YEARS.between(secondAthlete.birthDate, birthDate);
        if (year <= 0) {
            System.out.println(secondAthlete.name + " is " + -year + " years older than " + name);
        }
        else {
            System.out.println(secondAthlete.name + " is " + year + " years younger than " + name);
        }
    }

    // Overwriting toString() method.
    public String toString() {
        return "Athlete [" + name + ", " + weight + "kg, " + height + "m, " + gender + ", " + nationality + ", " + birthDate + "]";
    }
}



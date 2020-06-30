package domain;

import java.time.LocalDate;

public abstract class Person {
    private String name;
    private String surname;
    private LocalDate birthday;
    private String nationality;

    public Person(String name, String surname, LocalDate birthday, String nationality){
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.nationality = nationality;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setBirthday(LocalDate birthday){
        this.birthday = birthday;
    }

    public void setNationality(String nationality){
        this.nationality = nationality;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public LocalDate getBirthday(){
        return birthday;
    }

    public String getNationality(){
        return nationality;
    }

    public String toString(){
        return "Person [name: " + name + ", surname: " + surname + ", birthday: " + birthday + ", nationality: " + nationality + "]";
    }
}

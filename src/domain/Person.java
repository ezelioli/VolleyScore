package domain;

public abstract class Person {
    private String name;
    private String surname;
    private int age;
    private String nationality;

    public Person(String name, String surname, int age, String nationality){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.nationality = nationality;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setAge(int age){
        this.age = age;
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

    public int getAge(){
        return age;
    }

    public String getNationality(){
        return nationality;
    }

    public String toString(){
        return "Person [name: " + name + ", surname: " + surname + ", age: " + age + ", nationality: " + nationality + "]";
    }
}

package by.karpov.entity;

import java.util.Objects;

public abstract class Person {

    private Long id;
    private String name;
    private String surname;
    private String address;
    private Sex sex;


    public Person(Long id, String name, String surname, String address, Sex sex) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.sex = sex;

    }

    public Person(String name, String surname, String address, Sex sex) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.sex = sex;
    }

    public Person() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(address, person.address) &&
                sex == person.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, address, sex);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", sex=" + sex +
                '}';
    }
}


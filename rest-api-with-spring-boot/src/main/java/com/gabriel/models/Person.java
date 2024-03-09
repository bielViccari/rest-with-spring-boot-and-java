package com.gabriel.models;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false, length = 80)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 80)
    private String lastName;
    @Column(nullable = false, length = 100)
    private String address;
    @Column(nullable = false, length = 6)
    private String gender;

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // Sobrescreve o método equals para comparar objetos da classe Person
    @Override
    public boolean equals(Object o) {
        // Verifica se as referências dos objetos são iguais, economizando tempo
        if (this == o) return true;

        // Verifica se o objeto passado é nulo ou pertence a uma classe diferente
        if (o == null || getClass() != o.getClass()) return false;

        // Converte o objeto genérico para a classe Person para acessar seus campos
        Person person = (Person) o;

        // Compara os campos individuais usando equals e retorna o resultado da comparação
        return id == person.id &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(address, person.address) &&
                Objects.equals(gender, person.gender);
    }

    // Sobrescreve o método hashCode para gerar um código de hash para objetos da classe Person
    @Override
    public int hashCode() {
        // Gera o código de hash combinando os códigos de hash dos campos relevantes usando Objects.hash
        return Objects.hash(id, firstName, lastName, address, gender);
    }
}
package com.devsuperior.cruddeclientes.dto;

import com.devsuperior.cruddeclientes.entities.Client;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class ClientDTO {

    private long id;
    @NotEmpty(message = "O nome não pode ser vazio")
    private String name;
    private String cpf;
    private double income;
    @PastOrPresent(message = "Não pode ser data futura")
    private LocalDate birth_date;
    private int children;


    public ClientDTO() {
    }

    public ClientDTO(long id, String name, String cpf, double income, LocalDate birth_date, int children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birth_date = birth_date;
        this.children = children;
    }

    public ClientDTO(Client entity) {
        id = entity.getId();
        name = entity.getName();
        cpf = entity.getCpf();
        income = entity.getIncome();
        birth_date = entity.getBirthDate();
        children = entity.getChildren();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public double getIncome() {
        return income;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public int getChildren() {
        return children;
    }
}

package io.github.VladmirTaguerran.domain.entity;

import javax.persistence.*;

@Entity
@Table  //Quando o nome da tabela for diferente da classe adicionar indentificador
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    private String name;


    public Customers(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Customers() {
    }

    public Customers(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

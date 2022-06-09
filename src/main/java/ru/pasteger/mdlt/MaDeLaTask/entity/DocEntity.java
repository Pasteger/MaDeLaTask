package ru.pasteger.mdlt.MaDeLaTask.entity;

import javax.persistence.*;

@Entity
public class DocEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long code;
    private String name;

    public DocEntity() {}

    public Long getCode() {return code;}
    public void setCode(Long code) {this.code = code;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
}

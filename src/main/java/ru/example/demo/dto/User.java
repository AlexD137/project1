package ru.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_gen")
    @SequenceGenerator(name = "user_seq_gen", sequenceName = "user_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "firstname")
    @JsonProperty("firstname")
    private String firstName;
    @Column(name = "secondname")
    @JsonProperty("secondname")
    private String secondName;
    @Column(name = "age", nullable = false)
    private Integer age;
}
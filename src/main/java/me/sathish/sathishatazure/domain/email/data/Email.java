package me.sathish.sathishatazure.domain.email.data;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="emails")
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    @NotEmpty(message = "Email ID cannot be empty")
    private String emailID;
    @NotEmpty(message = "Name cannot be empty")
    private String name;
}

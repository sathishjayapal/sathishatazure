package me.sathish.sathishatazure.domain.road.data;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@Table(name = "roads")
@NoArgsConstructor
@AllArgsConstructor
public class Road {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    @NotEmpty(message = "Name cannot be empty")
    private String roadName;
    @Column
    @NotEmpty(message = "City cannot be empty")
    private String city;
    @Column
    @NotEmpty(message = "State cannot be empty")
    private String state;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}

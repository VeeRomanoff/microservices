package com.dolphin.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customer_id_seq",
            sequenceName = "customer_id_seq"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_seq"
    )
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
}

package edu.icet.model.entity;

import jakarta.persistence.*;
import lombok.*;

enum UserTier {
    REGULAR, VIP, PLATINUM
}

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String userId;
    private String name;
    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private UserTier tier;
}
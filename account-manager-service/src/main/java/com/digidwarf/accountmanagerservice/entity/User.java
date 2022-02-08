package com.digidwarf.accountmanagerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "userk")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private UUID uuid;
    private String name;
    private String surname;
    @ManyToOne
    private Email email;
    @ManyToOne
    private Region region;
    private LocalDateTime createdDateTime;
    private boolean isMailVerified;
    private boolean isActive;
    @Enumerated(value = EnumType.STRING)
    private UserRole role;
    private String picUrl;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "account_skill",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "skill_id")}
    )
    private List<Visit> visits;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "user_privilege",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "privilege_id")}
    )
    private List<UserPrivilege> privileges;

}
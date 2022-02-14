package com.digidwarf.emailservice.entity;


import com.vladmihalcea.hibernate.type.array.ListArrayType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "mailHistory")
@TypeDef(
        name = "list-array",
        typeClass = ListArrayType.class
)
public class MailHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userEmail;
    @Type(type = "list-array")
    @Column(
            name = "send_email_type",
            columnDefinition = "text[]"
    )
    private List<String> sendEmailType;

}

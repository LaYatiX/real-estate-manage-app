package pl.gpiwosz.estate.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode
@Table(name = "system_user")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SystemUser extends AuditModel{
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    private String username;
    private String password;
    @Column(name = "active")
    private Boolean active = true;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    protected List<Role> roles;

    public SystemUser(User user, String username, String password, Boolean active, List<Role> roles) {
        this.user = user;
        this.username = username;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }
}
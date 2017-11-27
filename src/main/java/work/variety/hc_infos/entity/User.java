package work.variety.hc_infos.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name="users")
@NoArgsConstructor
public class User implements UserDetails, Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Getter @Setter @NonNull
    private String username;
    @Getter @Setter @NonNull
    private String phone;
    @Getter @Setter @NonNull
    private String weixinId;
    @Getter @Setter @NonNull
    private int buildingNo;
    @Getter @Setter @NonNull
    private int unitNo;
    @Getter @Setter @NonNull
    private int roomNo;
    @Getter @Setter @NonNull
    private String password;
    @Getter @Setter @NonNull
    private String salt;
    @Getter @Setter @NonNull
    private int status;
    @Getter @Setter @NonNull
    private Date createdAt;

    public User(String username, String weixinId, String phone, int buildingNo, int unitNo, int roomNo){
        this.username = username;
        this.weixinId = weixinId;
        this.phone = phone;
        this.buildingNo = buildingNo;
        this.unitNo = unitNo;
        this.roomNo = roomNo;
        this.status = UserStatusEnum.ACTIVE.getStatus();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

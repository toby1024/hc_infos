package work.variety.hc_infos.entity;

import lombok.*;
import org.apache.commons.lang3.time.DateUtils;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "infos")
@Data
@NoArgsConstructor
public class Info {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Getter @Setter @NonNull
    private String title;
    @Getter @Setter @NonNull
    private String description;
    @Getter @Setter @NonNull
    private Date expiryDate;
    @Getter @Setter @NonNull
    private Integer status;
    @Getter @Setter @NonNull
    private Integer category;
    @Getter @Setter @NonNull
    private Date createdAt;
    @Getter @Setter @NonNull
    private Date updatedAt;
    @ManyToOne
    private User user;

    public Info(User user, String title, String description, InfoCategoryEnum categoryEnum){
        this.user = user;
        this.title = title;
        this.description = description;
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.expiryDate = DateUtils.addDays(new Date(), 30);
        this.status = InfoStatusEnum.ACTIVE.getStatus();
        this.category = categoryEnum.getCategory();
    }

    public boolean isRequest(){
        return category == InfoCategoryEnum.REQUEST.getCategory();
    }
}
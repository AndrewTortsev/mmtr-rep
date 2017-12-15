package tutorial;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {
    private static final long serialVersionUID = -5527566248002296042L;

    @Id
    @Column(name = "ACCOUNT_ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "ORGANIZATION_ID")
    private Integer orgId;
}


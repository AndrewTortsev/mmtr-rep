package tutorial;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TEST02", schema = "ZAKUPKI_DEV")
public class TEST implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "F1")
    private char f1;
    @Column(name = "F2")
    private char f2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public char getF1() {
        return f1;
    }

    public void setF1(char f1) {
        this.f1 = f1;
    }

    public char getF2() {
        return f2;
    }

    public void setF2(char f2) {
        this.f2 = f2;
    }

    public char getF3() {
        return f3;
    }

    public void setF3(char f3) {
        this.f3 = f3;
    }

    @Column(name = "F3")
    private char f3;
}


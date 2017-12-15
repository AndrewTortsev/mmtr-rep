package tutorial;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TEST01")
public class TEST implements Serializable {

    private static final long serialVersionUID = -5527566248002296042L;
    @Id
    @Column(name = "S_TABLE_NAME")
    private String tableName;
    @Id
    @Column(name = "S_COLUMN_NAME")
    private String columnName;
    @Id
    @Column(name = "S_SUBSTRING")
    private String subString;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getSubString() {
        return subString;
    }

    public void setSubString(String subString) {
        this.subString = subString;
    }
}


package counter.com.model;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "Number")
@Entity
public class NumberModel {
    @Id
    private Integer id;
    @Column(name="count")
    private Integer count;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberModel number = (NumberModel) o;
        return Objects.equals(id, number.id) &&
                Objects.equals(count, number.count);
    }




    @Override
    public int hashCode() {
        return Objects.hash(id, count);
    }

    @Override
    public String toString() {
        return "Number{" +
                "id=" + id +
                ", count=" + count +
                '}';
    }
}

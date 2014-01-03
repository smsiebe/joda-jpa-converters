package candlelight.joda.converters.example;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.joda.time.DateTime;

/**
 * Test Entity which includes the org.joda.time.DateTime object
 */
@Entity
public class DateTimeContainingEntity implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    //@Convert(converter = JodaDateTimeConverter.class) <--don't need to do this, autoApply is true
    private DateTime dateTime;

    public DateTimeContainingEntity() {
    }

    public DateTimeContainingEntity(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    protected void setId(Long id) {
        this.id = id;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DateTimeContainingEntity other = (DateTimeContainingEntity) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}

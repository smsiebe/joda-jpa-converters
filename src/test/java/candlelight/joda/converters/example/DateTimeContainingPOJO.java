package candlelight.joda.converters.example;

import org.joda.time.DateTime;

/**
 * Test POJO containing a joda DateTime without JPA annotations (for use with
 * orm.xml mapping)
 */
public class DateTimeContainingPOJO {

    private Long id;
    private DateTime dateTime;

    public DateTimeContainingPOJO() {
    }

    public DateTimeContainingPOJO(DateTime dateTime) {
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
        final DateTimeContainingPOJO other = (DateTimeContainingPOJO) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}

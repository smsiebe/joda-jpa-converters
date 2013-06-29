package candlelight.joda.converters;

import java.util.Date;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.joda.time.DateTime;

/**
 * Joda DateTime <-> JPA 2.1 converter
 */
@Converter(autoApply = true)
public class JodaDateTimeConverter implements AttributeConverter<DateTime, Date> {

    public Date convertToDatabaseColumn(DateTime dateTime) {
        return dateTime.toDate();
    }

    public DateTime convertToEntityAttribute(Date date) {
        return new DateTime(date);
    }
}

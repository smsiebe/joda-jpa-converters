/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package candlelight.joda.converters;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

public class JodaLocalDateConverterTest {

    private final static Long MILLS = System.currentTimeMillis();
    private final static Date date;
    private final static LocalDate LOCALDATE = new LocalDate(MILLS, DateTimeZone.UTC);

    static {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        cal.setTimeInMillis(MILLS);
        date = cal.getTime();

    }

    @Test
    public void testConvertToLocalDate() {
        JodaLocalDateConverter converter = new JodaLocalDateConverter();
        assertEquals(LOCALDATE, converter.convertToEntityAttribute(date));
    }

    @Test
    public void testConvertFromLocalDate() {
        JodaLocalDateConverter converter = new JodaLocalDateConverter();
        DateTime datetime = new DateTime(date);
        assertEquals(datetime.toLocalDate().toDate(), converter.convertToDatabaseColumn(LOCALDATE));
    }
}
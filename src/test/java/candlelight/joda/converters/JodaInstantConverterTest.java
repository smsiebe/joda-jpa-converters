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
import org.joda.time.Instant;
import org.junit.Test;
import static org.junit.Assert.*;

public class JodaInstantConverterTest {
    
    private final static Long MILLS = System.currentTimeMillis();
    private final static Date date;
    private final static Instant INSTANT = new Instant(MILLS);
    
    static {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        cal.setTimeInMillis(MILLS);
        date = cal.getTime();
    }
    
    @Test
    public void testConverationToInstant() {
        JodaInstantConverter converter = new JodaInstantConverter();
        assertEquals(INSTANT, converter.convertToEntityAttribute(date));
    }
    
    @Test    
    public void testConverationFromInstant() {
        JodaInstantConverter converter = new JodaInstantConverter();
        assertEquals(date, converter.convertToDatabaseColumn(INSTANT));
    }
}
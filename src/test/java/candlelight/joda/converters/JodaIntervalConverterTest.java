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
import org.joda.time.Interval;
import org.junit.Test;
import static org.junit.Assert.*;

public class JodaIntervalConverterTest {

    private final static Interval interval;
    private final static long start;
    private final static long end;

    static {
        Calendar cal = Calendar.getInstance(); //timezone doesn't matter here
        start = cal.getTimeInMillis();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        end = cal.getTimeInMillis();
        interval = new Interval(start, end);
    }

    @Test
    public void testConversionToFromInterval() {
        JodaIntervalConverter converter = new JodaIntervalConverter();
        String serialized = converter.convertToDatabaseColumn(interval);
        Interval deserialized = converter.convertToEntityAttribute(serialized);

        assertEquals("Start date was not recovered", start, deserialized.getStartMillis());
        assertEquals("End date was not recovered", end, deserialized.getEndMillis());
        assertEquals("Duration was not recovered", interval.toDuration(), deserialized.toDuration()); //added more for the reader, we're not testing Joda here
    }
}
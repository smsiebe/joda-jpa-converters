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

import org.joda.time.Duration;
import org.junit.Test;
import static org.junit.Assert.*;

public class JodaDurationConverterTest {

    private final static Long MILLS = 42L;
    private final static Duration DURATION = Duration.millis(MILLS);

    @Test
    public void testConversionFromDuration() {
        JodaDurationConverter converter = new JodaDurationConverter();
        assertEquals(DURATION, converter.convertToEntityAttribute(MILLS));
    }

    @Test
    public void testConverationToDuration() {
        JodaDurationConverter converter = new JodaDurationConverter();
        assertEquals(MILLS, converter.convertToDatabaseColumn(DURATION));
    }
}
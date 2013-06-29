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

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.joda.time.Interval;

/**
 * Converts a Joda Interval <-> JPA 2.1
 *
 * An Interval is a complex temporal type, maintaining the start and end
 * instants and deriving the period of time between the two instants. Converting
 * this type into a JPA/SQL time is not possible using a simple Converter (can
 * only serialize to a single field), so we do our best here by serializing the
 * Interval as a String.
 */
@Converter
public class JodaIntervalConverter implements AttributeConverter<Interval, String> {

    public String convertToDatabaseColumn(Interval interval) {
        return interval.toString();
    }

    public Interval convertToEntityAttribute(String string) {
        return Interval.parse(string);
    }
}

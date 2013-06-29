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
import org.joda.time.Duration;

/**
 * Joda Duration <-> JPA 2.1 converter
 */
@Converter(autoApply = true)
public class JodaDurationConverter implements AttributeConverter<Duration, Long> {

    public Long convertToDatabaseColumn(Duration duration) {
        return duration.getMillis();
    }

    public Duration convertToEntityAttribute(Long mills) {
        return new Duration(mills);
    }
}

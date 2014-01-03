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

import candlelight.joda.converters.example.DateTimeContainingEntity;
import candlelight.joda.converters.example.DateTimeContainingPOJO;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class JodaDateTimeConverterTest {

    private final static Long MILLS = System.currentTimeMillis();
    private final static Date date;
    private final static DateTime DATETIME = new DateTime(MILLS, DateTimeZone.UTC);

    static {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        cal.setTimeInMillis(MILLS);
        date = cal.getTime();
    }

    @Test
    public void testConversionToDateTime() {
        JodaDateTimeConverter converter = new JodaDateTimeConverter();
        assertTrue(DATETIME.isEqual(converter.convertToEntityAttribute(date)));
    }

    @Test
    public void testConversionFromDateTime() {
        JodaDateTimeConverter converter = new JodaDateTimeConverter();
        assertEquals(date, converter.convertToDatabaseColumn(DATETIME));
    }

    @Test
    public void testPersistEntity() {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("jodaConverterTestPU");
            em = emf.createEntityManager();
            final DateTime current = DateTime.now();

            DateTimeContainingEntity entity = new DateTimeContainingEntity(current);
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(entity);
            tx.commit();

            tx = em.getTransaction();
            tx.begin();
            DateTimeContainingEntity result = em.find(DateTimeContainingEntity.class, entity.getId());
            tx.commit();

            assertEquals(current, result.getDateTime());
        } catch (Exception ex) {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
    
    @Test
    public void testPersistEntityORM() {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("jodaConverterTestORMPU");
            em = emf.createEntityManager();
            final DateTime current = DateTime.now();

            DateTimeContainingPOJO entity = new DateTimeContainingPOJO(current);
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(entity);
            tx.commit();

            tx = em.getTransaction();
            tx.begin();
            DateTimeContainingPOJO result = em.find(DateTimeContainingPOJO.class, entity.getId());
            tx.commit();

            assertEquals(current, result.getDateTime());
        } catch (Exception ex) {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
}

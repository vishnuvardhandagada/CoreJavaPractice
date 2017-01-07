package core.java;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Date manipulation practice class
 * @author Donthu Avinash Babu
 *
 */
public class DatePractice {

    /**
     * java.time.Clock practice
     */
    @Ignore
    @Test
    public void clock() {
	Clock clock = Clock.systemUTC();
	System.out.println("clock.instant(): " + clock.instant());
	System.out.println("clock.millis(): " + clock.millis());
	System.out.println("clock.getZone(): " + clock.getZone());
    }

    /**
     * java.time.LocalDate practice. This class will have only date part without time part
     */
    @Ignore
    @Test
    public void localDate() {
	LocalDate localDate1 = LocalDate.now();
	System.out.println("localDate: " + localDate1);

	Clock clock1 = Clock.systemUTC();
	LocalDate localDate2 = LocalDate.now(clock1);
	System.out.println("localDate2: " + localDate2);
    }

    /**
     * java.time.LocalTime practice. This class will have only time part without date
     */
    @Ignore
    @Test
    public void localTime() {
	LocalTime localTime1 = LocalTime.now();
	System.out.println("localTime1: " + localTime1);

	Clock clock1 = Clock.systemUTC();
	LocalTime localTime2 = LocalTime.now(clock1);
	System.out.println("localTime2: " + localTime2);

	Clock clock2 = Clock.systemDefaultZone();
	LocalTime localTime3 = LocalTime.now(clock2);
	System.out.println("localTime3: " + localTime3);
    }

    /**
     * java.time.LocalDateTime practice. This class useful to work on date or time or both
     */
    @Ignore
    @Test
    public void localDateTime() {
	LocalDateTime localDateTime1 = LocalDateTime.now();
	System.out.println("localDateTime1: " + localDateTime1);

	Clock clock1 = Clock.systemUTC();
	LocalDateTime localDateTime2 = LocalDateTime.now(clock1);
	System.out.println("localDateTime2: " + localDateTime2);

	Clock clock2 = Clock.systemDefaultZone();
	LocalDateTime localDateTime3 = LocalDateTime.now(clock2);
	System.out.println("localDateTime3: " + localDateTime3);
    }

    /**
     * java.time.ZonedDateTime practice
     */
    @Ignore
    @Test
    public void zonedDateTime() {
	ZonedDateTime zonedDateTime1 = ZonedDateTime.now();
	System.out.println("zonedDateTime1: " + zonedDateTime1);

	Clock clock1 = Clock.systemUTC();
	ZonedDateTime zonedDateTime2 = ZonedDateTime.now(clock1);
	System.out.println("zonedDateTime2: " + zonedDateTime2);

	ZonedDateTime zonedDateTime3 = ZonedDateTime.now(ZoneId.of("Asia/Calcutta"));
	System.out.println("zonedDateTime3: " + zonedDateTime3);
    }

    /**
     * java.time.Duration practice.
     */
    @Ignore
    @Test
    public void duration() {
	LocalDateTime localDateTime1 = LocalDateTime.of(2014, Month.NOVEMBER, 27, 15, 50);
	LocalDateTime localDateTime2 = LocalDateTime.of(2016, Month.NOVEMBER, 27, 15, 50);

	Duration duration1 = Duration.between(localDateTime1, localDateTime2);
	System.out.println("duration1: " + duration1);
	System.out.println("days: " + duration1.toDays());
	System.out.println("months: " + duration1.toDays() / 30);
	System.out.println("years: " + (duration1.toDays() / 30) / 12);
	System.out.println("hours: " + duration1.toHours());
	System.out.println("minutes: " + duration1.toMinutes());
	System.out.println("seconds: " + duration1.getSeconds());
    }

    @Ignore
    @Test
    public void convertUtilDateToLocalDate() {
	Date date = new Date();
	System.out.println("convertUtilDateToLocalDate() date: " + date);

	Instant instant = date.toInstant();
	System.out.println("convertUtilDateToLocalDate() instant: " + instant);

	ZoneId systemDefaultZoneId = ZoneId.systemDefault();
	LocalDate localDate = instant.atZone(systemDefaultZoneId).toLocalDate();
	System.out.println("convertUtilDateToLocalDate() localDate: " + localDate);
    }

    @Ignore
    @Test
    public void convertLocalDateToUtilDate() {
	LocalDate localDate = LocalDate.now();
	System.out.println("convertLocalDateToUtilDate() localDate: " + localDate);

	ZoneId zoneId = ZoneId.systemDefault();
	Date date = Date.from(localDate.atStartOfDay(zoneId).toInstant());
	System.out.println("convertLocalDateToUtilDate() date: " + date);
    }

    @Ignore
    @Test
    public void convertUtilDateToLocalDateTime() {
	Date date = new Date();
	System.out.println("convertUtilDateToLocalDateTime() date: " + date);

	Instant instant = date.toInstant();
	System.out.println("convertUtilDateToLocalDateTime() instant: " + instant);

	ZoneId systemDefaultZoneId = ZoneId.systemDefault();
	LocalDateTime localDateTime = instant.atZone(systemDefaultZoneId).toLocalDateTime();
	System.out.println("convertUtilDateToLocalDateTime() localDateTime: " + localDateTime);
    }

    @Ignore
    @Test
    public void convertLocalDateTimeToUtilDate() {
	Clock clock = Clock.systemDefaultZone();
	LocalDateTime localDateTime = LocalDateTime.now(clock);
	System.out.println("convertLocalDateTimeToUtilDate() localDateTime: " + localDateTime);

	ZoneId zoneId = ZoneId.systemDefault();
	Date date = Date.from(localDateTime.atZone(zoneId).toInstant());
	System.out.println("convertLocalDateTimeToUtilDate() date: " + date);
    }

    @Ignore
    @Test
    public void convertUtilDateToLocalTime() {
	Date date = new Date();
	System.out.println("convertUtilDateToLocalTime() date: " + date);

	Instant instant = date.toInstant();
	System.out.println("convertUtilDateToLocalTime() instant: " + instant);

	ZoneId systemDefaultZoneId = ZoneId.systemDefault();
	LocalTime localTime = instant.atZone(systemDefaultZoneId).toLocalTime();
	System.out.println("convertUtilDateToLocalTime() localTime: " + localTime);
    }

    @Ignore
    @Test
    public void convertUtilDateToZonedDateTime() {
	Date date = new Date();
	System.out.println("convertUtilDateToZonedDateTime() date: " + date);

	Instant instant = date.toInstant();
	System.out.println("convertUtilDateToZonedDateTime() instant: " + instant);

	ZoneId zoneId = ZoneId.systemDefault();
	ZonedDateTime zonedDateTime = instant.atZone(zoneId);
	System.out.println("convertUtilDateToZonedDateTime() zonedDateTime: " + zonedDateTime);
    }

    @Ignore
    @Test
    public void convertZonedDateTimeToUtilDate() {
	Clock clock = Clock.systemDefaultZone();
	ZonedDateTime zonedDateTime = ZonedDateTime.now(clock);
	System.out.println("convertZonedDateTimeToUtilDate() zonedDateTime: " + zonedDateTime);

	Date date = Date.from(zonedDateTime.toInstant());
	System.out.println("convertZonedDateTimeToUtilDate() date: " + date);
    }

    //    @Ignore
    @Test
    public void convertLocalDateTimeToZonedDateTime() {
	Clock clock = Clock.systemDefaultZone();
	LocalDateTime localDateTime = LocalDateTime.now(clock);
	System.out.println("convertLocalDateTimeToZonedDateTime() localDateTime: " + localDateTime);

	ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
	System.out.println("convertLocalDateTimeToZonedDateTime() zonedDateTime: " + zonedDateTime);
    }

}

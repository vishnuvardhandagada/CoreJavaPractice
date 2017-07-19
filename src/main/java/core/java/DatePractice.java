package core.java;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

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

	@Ignore
	@Test
	public void convertLocalDateTimeToZonedDateTime() {
		Clock clock = Clock.systemDefaultZone();
		LocalDateTime localDateTime = LocalDateTime.now(clock);
		System.out.println("convertLocalDateTimeToZonedDateTime() localDateTime: " + localDateTime);

		ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
		System.out.println("convertLocalDateTimeToZonedDateTime() zonedDateTime: " + zonedDateTime);
	}

	/**
	 * Method to convert one date format to another date format
	 * @throws ParseException 
	 */
	@Ignore
	@Test
	public void converDateFormat1() throws ParseException {
		/*convert date from yyyy-mm-dd to mm/dd/yyyy*/
		DateFormat fromFormat1 = new SimpleDateFormat("yyyy-mm-dd");
		DateFormat toFormat1 = new SimpleDateFormat("mm/dd/yyyy");

		Date date = fromFormat1.parse("2017-01-27");
		String convertedDate1 = toFormat1.format(date);
		System.out.println("convertedDate1: " + convertedDate1);

		/*convert date from yyyy-mm-dd to dd/mm/yyyy*/
		DateFormat fromFormat2 = new SimpleDateFormat("yyyy-mm-dd");
		DateFormat toFormat2 = new SimpleDateFormat("dd/mm/yyyy");
		Date date2 = fromFormat2.parse("2017-01-27");
		String convertedDate2 = toFormat2.format(date2);
		System.out.println("convertedDate2: " + convertedDate2);

		/*convert date from dd/mm/yyyy to yyyy-mm-dd*/
		DateFormat fromFormat3 = new SimpleDateFormat("dd/mm/yyyy");
		DateFormat toFormat3 = new SimpleDateFormat("yyyy-mm-dd");
		Date date3 = fromFormat3.parse("27/01/2017");
		String convertedDate3 = toFormat3.format(date3);
		System.out.println("convertedDate3: " + convertedDate3);

		/*convert Thu Apr 20 22:52:16 IST 2017 to 2017/04/20*/
		SimpleDateFormat fromFormat4 = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		SimpleDateFormat toFormat4 = new SimpleDateFormat("yyyy/MM/dd");
		Date date4 = fromFormat4.parse("Thu Apr 20 22:52:16 IST 2017");
		String convertedDate4 = toFormat4.format(date4);
		System.out.println("convertedDate4: " + convertedDate4);

		// convert new Date to yyyy/MM/dd
		Date date5 = new Date();
		DateFormat toFormat5 = new SimpleDateFormat("yyyy/MM/dd");
		String convertedDate5 = toFormat5.format(date5);
		System.out.println("convertedDate5: " + convertedDate5);
	}

	/**
	 * Convert String to java.util.Date
	 * 
	 * String to Date -> SimpleDateFormat.parse(String)
	 * Date to String -> SimpleDateFormat.format(date)
	 * @throws ParseException 
	 */
	@Ignore
	@Test
	public void convertStringToUtilDate() throws ParseException {
		// 20-Jul-2017
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MMM-yyyy");
		String date1 = "20-Jul-2017";

		Date convertedDate1 = simpleDateFormat1.parse(date1);
		System.out.println("convertedDate1: " + convertedDate1);
		System.out.println("simpleDateFormat1.format(convertedDate1): "
				+ simpleDateFormat1.format(convertedDate1));

		// 20/07/2017
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
		String date2 = "20/07/2017";
		Date convertedDate2 = simpleDateFormat2.parse(date2);
		System.out.println("convertedDate2: " + convertedDate2);
		System.out.println("simpleDateFormat2.format(convertedDate2): "
				+ simpleDateFormat2.format(convertedDate2));

		//Thu, July 20 2017
		SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("E, MMM dd yyyy");
		String date3 = "Thu, July 20 2017";
		Date convertedDate3 = simpleDateFormat3.parse(date3);
		System.out.println("convertedDate3: " + convertedDate3);
		System.out.println("simpleDateFormat3.format(convertedDate3): "
				+ simpleDateFormat3.format(convertedDate3));

		//Thursday, July 10 2017 12:10:08 PM
		SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("EEEE, MMM dd yyyy HH:mm:ss a");
		String date4 = "Thursday, July 20 2017 12:10:08 PM";
		Date convertedDate4 = simpleDateFormat4.parse(date4);
		System.out.println("convertedDate4: " + convertedDate4);
		System.out.println("simpleDateFormat4.format(convertedDate4): "
				+ simpleDateFormat4.format(convertedDate4));

		// Sun Apr 16 22:52:16 EDT 2017
		SimpleDateFormat simpleDateFormat5 = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		simpleDateFormat5.setTimeZone(TimeZone.getTimeZone("EDT"));
		String date5 = "Sun Apr 16 22:52:16 EDT 2017";
		Date convertedDate5 = simpleDateFormat5.parse(date5);
		System.out.println("convertedDate5: " + convertedDate5);
		System.out.println("simpleDateFormat5.format(convertedDate5): "
				+ simpleDateFormat5.format(convertedDate5));
	}

	/**
	 * Convert String to java.time.LocalDate
	 */
	@Ignore
	@Test
	public void convertStringToLocalDate() {
		// 10/07/2017
		String date1 = "20/07/2017";
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate localDate1 = LocalDate.parse(date1, formatter1);
		System.out.println("localDate1: " + localDate1);
		System.out.println("formatter1.format(localDate1): " + formatter1.format(localDate1));

		//10-07-2017
		String date2 = "2017-07-21";
		LocalDate localDate2 = LocalDate.parse(date2);
		System.out.println("localDate2: " + localDate2);

		// 20-Jul-2017
		String date3 = "20-Jul-2017";
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("d-MMM-yyyy");
		LocalDate localDate3 = LocalDate.parse(date3, formatter2);
		System.out.println("localDate3: " + localDate3);
		System.out.println("formatter2.format(localDate3): " + formatter2.format(localDate3));

		//Thu, Jul 20 2017
		String date4 = "Thu, Jul 20 2017";
		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("E, MMM d yyyy");
		LocalDate localDate4 = LocalDate.parse(date4, formatter3);
		System.out.println("localDate4: " + localDate4);
		System.out.println("formatter3.format(localDate4): " + formatter3.format(localDate4));

		//Thursday, Jul 10 2017 12:10:08 PM
		String date5 = "Thursday, Jul 20 2017 12:10:08 PM";
		DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("EEEE, MMM d yyyy HH:mm:ss a");
		LocalDateTime localDate5 = LocalDateTime.parse(date5, formatter4);
		System.out.println("localDate5: " + localDate5);
		System.out.println("formatter4.format(localDate5): " + formatter4.format(localDate5));
	}

	/**
	 * Print day of week if date is given
	 */
	@Ignore
	@Test
	public void getDayOfWeek() {
		int year = 2015;
		int month = 8;
		int day = 5;

		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day);
		Date date = calendar.getTime();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
		System.out.println(simpleDateFormat.format(date).toUpperCase());
	}

	/**
	 * Convert java.time.LocalDateTime to java.sql.Timestamp
	 */
	@Test
	@Ignore
	public void convertLocalDateTimeToTimestamp() {
		LocalDateTime localDateTime = LocalDateTime.now(Clock.systemDefaultZone());
		System.out.println("localDateTime: " + localDateTime); // localDateTime: 2017-05-30T21:29:25.097
		Timestamp timestamp = Timestamp.from(localDateTime.toInstant(ZoneOffset.ofHours(0)));
		System.out.println("timestamp: " + timestamp); // timestamp: 2017-05-31 02:59:25.097
	}

	/**
	 * Add day, month and year to java.util.Date
	 */
	@Test
	@Ignore
	public void addDayMonthYearToJavaUtilDate() {
		Calendar calendar = Calendar.getInstance();
		System.out.println("Current Date: " + calendar.getTime());

		calendar.add(Calendar.DAY_OF_MONTH, 10);
		System.out.println("Add 10 days: " + calendar.getTime());

		calendar.add(Calendar.MONTH, 1);
		System.out.println("Add 1 month: " + calendar.getTime());

		calendar.add(Calendar.YEAR, 3);
		System.out.println("Add 3 years: " + calendar.getTime());

		calendar.add(Calendar.DAY_OF_MONTH, -5);
		System.out.println("Reduce 5 days: " + calendar.getTime());

		calendar.add(Calendar.MONTH, -2);
		System.out.println("Reduce 2 months: " + calendar.getTime());

		calendar.add(Calendar.YEAR, -4);
		System.out.println("Reduce 4 years: " + calendar.getTime());
	}

	/**
	 * Check whether input date is past date or not
	 * @throws ParseException
	 */
	@Ignore
	@Test
	public void dateFormatPractice() throws ParseException {
		String inputDate = "20170710";
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date convertDate = dateFormat.parse(inputDate);
		System.out.println("convertDate: " + convertDate);

		Instant instant = convertDate.toInstant();
		ZoneId systemDefaultZoneId = ZoneId.systemDefault();
		LocalDate localDate = instant.atZone(systemDefaultZoneId).toLocalDate();
		System.out.println("localDate: " + localDate);

		LocalDate today = LocalDate.now(Clock.systemDefaultZone());
		boolean isPast = localDate.isBefore(today);
		System.out.println("isPast: " + isPast);
	}
}
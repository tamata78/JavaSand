package date;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class DateUtils {
	/** 日付フォーマット(デフォルト) */
	public static final String DATE_FORMAT_DAFAULT = "yyyy-MM-dd";
	public static final String TIMESTAMP_FORMAT_DEFAULT = "yyyy-MM-dd HH:mm:ss.SSS";
	public static final String DATETIME_FORMAT_DAFAULT = "yyyy-MM-dd HH:mm:ss";

	/** 日付定数(00:00:00.000) */
	public static String TIME_FROM = "00:00:00.000";
	/** 日付定数(23:59:59.999) */
	public static String TIME_TO = "23:59:59.999";

	/**
	 * 日付を文字列にする(yyyy-MM-dd形式)
	 *
	 * @param date
	 * @return
	 */
	public static String toStr(Date date) {
		return toStr(date, DATE_FORMAT_DAFAULT);
	}

	/**
	 * 日付を文字列にする(フォーマット指定)
	 *
	 * @param date
	 * @return
	 */
	public static String toStr(Date date, String pattern) {
		if (date == null) {
			return null;
		}
		String strDate;

		try {
			DateFormat format = new SimpleDateFormat(pattern);
			strDate = format.format(date);
		} catch (Exception e) {
			strDate = null;
		}
		return strDate;
	}

	/**
	 * LocalDateから文字列に変更する
	 *
	 * @param ldate
	 * @return
	 */
	public static String toStr(LocalDate ldate) {
		return toStr(ldate, DATE_FORMAT_DAFAULT);
	}

	/**
	 * LocalDateから文字列に変更する(フォーマット指定)
	 *
	 * @param ldate
	 * @param pattern
	 * @return
	 */
	public static String toStr(LocalDate ldate, String pattern) {
		if (ldate == null) {
			return null;
		}
		DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
		return ldate.format(format);
	}

	/**
	 * LocalDateTimeから文字列に変更する(フォーマット指定)
	 *
	 * @param ldate
	 * @param pattern
	 * @return
	 */
	public static String toStr(LocalDateTime localDateTime, String pattern) {
		if (localDateTime == null) {
			return null;
		}
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
		return localDateTime.format(dateTimeFormatter);
	}

	/**
	 * 文字列を日付にする
	 *
	 * @param date
	 * @return
	 */
	public static Date parseStrToDate(String dateStr) {
		return parseStrToDate(dateStr, DATE_FORMAT_DAFAULT);
	}

	/**
	 * 文字列を日付にする(フォーマット指定)
	 *
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date parseStrToDate(String dateStr, String pattern) {
		if (StringUtils.isEmpty(dateStr)) {
			return null;
		}
		Date date;

		try {
			DateFormat format = new SimpleDateFormat(pattern);
			date = format.parse(dateStr);
		} catch (Exception e) {
			date = null;
		}
		return date;
	}

	/**
	 * LocalDateからjava.util.Dateに変換する
	 *
	 * @param strDate
	 * @return
	 */
	public static Date toDate(LocalDate lcDate) {
		if (lcDate == null) {
			return null;
		}
		Date result;
		try {
			ZonedDateTime zdt = lcDate.atStartOfDay(ZoneOffset.ofHours(9));
			result = Date.from(zdt.toInstant());
			;
		} catch (Exception e) {
			result = null;
		}
		return result;
	}

	/**
	 * LcalDatetimeをDateに変換する(JST)
	 *
	 * @param ltime
	 * @return
	 */
	public static Date toDate(LocalDateTime ltime) {
		if (ltime == null) {
			return null;
		}
		Instant ins = ltime.toInstant(ZoneOffset.ofHours(9));
		Date date = Date.from(ins);

		return date;
	}

	/**
	 * LcalDatetimeをDateに変換する(UTC)
	 *
	 * @param ltime
	 * @return
	 */
	public static Date toDateUtc(LocalDateTime ltime) {
		if (ltime == null) {
			return null;
		}
		Instant ins = ltime.toInstant(ZoneOffset.UTC);
		Date date = Date.from(ins);

		return date;
	}

	/**
	 * 文字列からLocalDateに変換する(yyyy-MM-dd形式)
	 *
	 * @param strDate
	 * @return
	 */
	public static LocalDate parseLocalDate(String strDate) {
		return parseLocalDate(strDate, DATE_FORMAT_DAFAULT);
	}

	/**
	 * 文字列からLocalDateに変換する(フォーマット指定)
	 *
	 * @param strDate
	 * @return
	 */
	public static LocalDate parseLocalDate(String strDate, String format) {
		if (StringUtils.isEmpty(strDate)) {
			return null;
		}
		LocalDate result;
		try {
			result = LocalDate.parse(strDate, DateTimeFormatter.ofPattern(format));
		} catch (Exception e) {
			result = null;
		}
		return result;
	}

	/**
	 * Date から LocalDateへ変換する
	 *
	 * @param date
	 * @return
	 */
	public static LocalDate toLocalDate(Date date) {
		LocalDate result;
		ZonedDateTime zdt = ZonedDateTime.ofInstant(date.toInstant(), ZoneOffset.ofHours(9));
		result = zdt.toLocalDate();
		return result;
	}

	/**
	 * Date から LocalDateTimeへ変換する
	 *
	 * @param date
	 * @return
	 */
	public static LocalDateTime toLocalDateTime(Date date) {
		return LocalDateTime.ofInstant(date.toInstant(), ZoneOffset.ofHours(9));
	}

	public static Timestamp toTimestamp(String date, String time) {
		Timestamp stamp;
		try {
			DateFormat format = new SimpleDateFormat(TIMESTAMP_FORMAT_DEFAULT);
			stamp = new Timestamp(format.parse(date + " " + time).getTime());
		} catch (Exception e) {
			stamp = null;
		}
		return stamp;
	}

	/**
	 * 文字列をsql.Dateに変換にする
	 *
	 * @param date
	 * @return
	 */
	public static java.sql.Date parseStrToSqlDate(String dateStr) {
		return parseStrToSqlDate(dateStr, DATE_FORMAT_DAFAULT);
	}

	/**
	 * 文字列をsql.Dateに変換する(フォーマット指定)
	 *
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static java.sql.Date parseStrToSqlDate(String dateStr, String pattern) {
		if (StringUtils.isEmpty(dateStr)) {
			return null;
		}
		java.sql.Date sqlDate;

		try {
			DateFormat format = new SimpleDateFormat(pattern);
			Date date = format.parse(dateStr);
			sqlDate = new java.sql.Date(date.getTime());
		} catch (Exception e) {
			sqlDate = null;
		}
		return sqlDate;
	}

	/**
	 * util.Dateをsql.Dateに変換する
	 *
	 * @param date
	 * @return
	 */
	public static java.sql.Date parseSqlDate(Date date) {
		if (date == null) {
			return null;
		}
		return new java.sql.Date(date.getTime());
	}

	public static Date today() {
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}

	public static LocalDate todayLocalDate() {
		return LocalDate.now();
	}

	/**
	 * 明日日付を返却する
	 *
	 * @param targetDate LocalDate
	 * @return
	 */
	public static LocalDate tomorrow(LocalDate targetDate) {
		if (targetDate == null) {
			return null;
		}
		return targetDate.plus(Period.ofDays(1));
	}

	/**
	 * 現在日時をミリ秒表示する
	 *
	 * @return
	 */
	public static Timestamp currentDateTimeMillis() {
		return new Timestamp(System.currentTimeMillis());
	}

}
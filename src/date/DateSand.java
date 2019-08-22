package date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateSand {
	public static void main(String[] args) {
		/** LocalDate **/
		// LocalDate内で変換 LocalDateTime -> LocalDate, LocalTime
		LocalDateTime dateTime3 = LocalDateTime.of(2013, 12, 4, 10, 30, 45);
		LocalDate date3 = dateTime3.toLocalDate();
		LocalTime time3 = dateTime3.toLocalTime();

		// 日付演算
		LocalDate today = LocalDate.now(); // 今日の日付
		LocalDate twoDaysAfter = today.plusDays(2L); // 2日後

		// 日付文字列
		LocalDate dateFromStr = LocalDate.of(2013, 2, 28);
		System.out.println("dateFromStr:" + dateFromStr); // dateFromStr: 2013-02-28

		LocalDate dateParse = LocalDate.parse("2013/07/07", DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		System.out.println("dateParse:" + dateParse); // dateParse; 2013-07-07

		/** Timestamp **/
		// 現在日時のミリ秒表示
		System.out.println(DateUtils.currentDateTimeMillis());

	}
}

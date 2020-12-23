package optional;

import java.util.Optional;

public class OptionalSand {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		createOptional();

		getOptionalVal();

		processOptionalNull();

	}

	private static void processOptionalNull() {
		/** Optionalの値がnull時の処理 **/

		// orElse
		String str = "nonNull";
		Optional<String> nullableString = Optional.ofNullable(str);
		System.out.println(nullableString.orElse("other")); // nonNull

		str = null;
		Optional<String> nullableString1 = Optional.ofNullable(str);
		System.out.println(nullableString1.orElse("other")); // other

		// orElseGet Supplierの結果を返却
		System.out.println(nullableString1.orElseGet(() -> "other")); // other

		// orElseThrow
		nullableString1.orElseThrow(RuntimeException::new);
	}

	private static void getOptionalVal() {
		// Optionalから値取得
		String str1 = "test";
		Optional<String> nullableStr1 = Optional.ofNullable(str1);
		nullableStr1.get();

		String str2 = null;
		Optional<String> nullableStr2 = Optional.ofNullable(str2);
		nullableStr2.get(); //// java.util.NoSuchElementException: No value present

		// Optionalに値が存在するか
		nullableStr1.isPresent(); //true
	}

	private static void createOptional() {
		// 空のOptionalを返却
		Optional<String> empty = Optional.empty();
		empty.isPresent(); // false
		empty.orElse("other"); // other
		empty.get(); // java.util.NoSuchElementException: No value present


		// of 非null値を持つOptionalを返却
		String str = "nonNull";
		Optional<String> nonNullString = Optional.of(str);
		nonNullString.isPresent(); // true
		nonNullString.get(); // result : nonNull

		String str2 = null;
		Optional.of(str2); //  java.lang.NullPointerException


		//nullかもしれない値(nullable)を持つOptionalオブジェクトを返却
		String str3 = null;
		Optional<String> nullableString = Optional.ofNullable(str3);
		nullableString.isPresent();// false
		nullableString.orElse("other");// other
	}

}

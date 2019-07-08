package base.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleClass<T> {
	private T t;
	private List<T> list = new ArrayList<T>();

	// インスタンスメソッド
	public void set(T arg) {
		this.t = arg;
	}

	public T get() {
		return this.t;
	}

	// staticなGenericsメソッド

// tは非staticな変数のため以下の書き方はコンパイルエラー
//	static {
//		T t;
//	}
//
//	public static void hoge(T t) {
//
//	}

	// 戻り値の前に <T>を書いて置くとエラーにならない。
	public static <T> List<T> someMethod(T t) {
		List<T> list = new ArrayList<T>();
		list.add(t);
		return list;
	}

	// 複数型パラメータ
	public static <K, V> Map<K, V> generateMap() {
		return new HashMap<K, V>();
	}
}

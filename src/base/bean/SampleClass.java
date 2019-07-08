package base.bean;

import java.util.ArrayList;
import java.util.List;

public class SampleClass<T> {
	private T t;
	private List<T> list = new ArrayList<T>();

	public void set(T arg) {
		this.t = arg;
	}

	public T get() {
		return this.t;
	}
}

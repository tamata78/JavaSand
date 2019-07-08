package base;

import base.bean.NumArrayList;

public class GenericsSandbox {
	// 境界型パラメータなクラスをnewしてみる
	NumArrayList<Number> numList = new NumArrayList<Number>();
	NumArrayList<Double> doubleList = new NumArrayList<Double>();

	// これはコンパイルエラー
	// NumArrayList<String> stringList = new NumArrayList<String>();
}

package base.bean;

import java.util.ArrayList;

/**
 * 数値型のみを格納できるArrayList<br>
 * <br>
 * 境界型パラメータを用いてNumber型に縛る
 * 
 * @author tamata78
 *
 * @param <T>
 */
public class NumArrayList<T extends Number> extends ArrayList<T> {
    private static final long serialVersionUID = 1L;

}

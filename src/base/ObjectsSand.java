package base;

import base.bean.NumArrayList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class ObjectsSand {
    public static void main(String[] args) {
        // Objects.requireNonNull
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime now2 = Objects.requireNonNull(now);

        Boolean boolTrue1 = Objects.isNull(null); // nullの場合
        Boolean boolTrue2 = Objects.nonNull(new ArrayList<String>()); // null以外の場合

        Object obj = null;
        System.out.println(Objects.toString(obj, "nullです。")); // 第二引数はなしでもOK
    }
}


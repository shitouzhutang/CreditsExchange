package com.model.po;

/**
 * Created by Administrator on 2017/3/16.
 */
public class Ref {
    private  String $ref;

    public String get$ref() {
        return $ref;
    }

    public void set$ref(String $ref) {
        this.$ref = $ref;
    }

    @Override
    public String toString() {
        return "Ref{" +
                "$ref='" + $ref + '\'' +
                '}';
    }
}

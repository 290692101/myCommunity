package com.ch.chMbTest.entity;

public enum Enabled {
    //role角色 enabled字段对应的枚举类
//    disabled,//禁用
//    enabled; //启用

    //如果不使用基于索引的转换 比如 enabled在前 disabled在后
    enabled(1),
    disabled(0);


    private final int value;
    Enabled( int value) {

        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

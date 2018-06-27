package cn.vpclub.demo.common.model.core.enums;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


public enum AppServiceEnum {
    USER(0, "用户"),
    USER_LEVEL(1, "用户等级"),
    PRODUCT(2, "商品"),
    SMS(3, "短信"),
    LOGISTICS(4, "物流/快递"),
    PAYMENT(5, "支付"),
    ORDER_QUERY(6, "支付订单查询"),
    LOGISTICS_COMPANY(7, "物流公司");

    private Integer code;
    private String value;

    private AppServiceEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public final Integer getCode() {
        return this.code;
    }

    public final String getValue() {
        return this.value;
    }

    public String toString() {
        return this.code + "=" + this.value;
    }
}


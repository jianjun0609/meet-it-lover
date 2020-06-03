package com.lover.common.enums;

public enum StatusEnum {
	YES(1, "是"), NO(0, "否");

	public Integer value;
	public String des;

	StatusEnum(Integer value, String des) {
		this.value = value;
		this.des = des;
	}

	public static StatusEnum getType(Integer value) {
		for (StatusEnum type : values()) {
			if (type.getValue().equals(value)) {
				return type;
			}
		}
		return null;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}
}

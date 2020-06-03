package com.lover.common.enums;

public enum YmPicTypeEnum {
	YM_WIN(1, "元梦荣获"),
	YM_PARTNER(2, "元梦伙伴"),
	YM_OUYU(3, "偶遇元梦人");

	public Integer value;
	public String des;

	YmPicTypeEnum(Integer value, String des) {
		this.value = value;
		this.des = des;
	}

	public static YmPicTypeEnum getType(Integer value) {
		for (YmPicTypeEnum type : values()) {
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

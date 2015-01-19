package com.dimit.excel;

/**
 * Dimit 2015年1月18日
 * excel文件的Format对象
 */
public class Format {
	/** 配置文件位置*/
	private String location;
	/** 配置文件类型*/
	private String type;
	/** 配置文件后缀名*/
	private String suffix;
	/** 配置文件的配置信息*/
	private String config;
	/** sheet空间名称*/
	private String sheet;
	//getters方法
	
	public String getLocation() {
		return location;
	}

	public String getType() {
		return type;
	}

	public String getSuffix() {
		return suffix;
	}

	public String getConfig() {
		return config;
	}

	public String getSheet() {
		return sheet;
	}

	@Override
	public String toString() {
		return "Format [location=" + location + ", type=" + type + ", suffix="
				+ suffix + ", config=" + config + "]";
	}

	//valueOf方法
	/**
	 * @param location 文件URL路径
	 * @param type 文件类型
	 * @param suffix 文件后缀
	 * @param config 文件配置信息
	 * @return
	 */
	public static Format valueOf(String location, String type, String suffix, String config , String sheet) {
		Format format = new Format();
		format.location = location;
		format.type = type;
		format.suffix = suffix;
		format.config = config;
		format.sheet = sheet;
		return format;
	}
	
	
}

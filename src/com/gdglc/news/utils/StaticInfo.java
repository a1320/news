package com.gdglc.news.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class StaticInfo implements Serializable{
	public static final Map<String, String> TYPE_MAP= new HashMap<String, String>();
	static {
		TYPE_MAP.put(".jpg", "");
		TYPE_MAP.put(".doc", "");
		TYPE_MAP.put(".docx", "");
	}
}

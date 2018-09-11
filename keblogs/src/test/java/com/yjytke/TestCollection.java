package com.yjytke;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wuynje
 * @time 2018年9月11日 上午11:00:32
 * @version 1.0
 * @description:测试求补集
 */
public class TestCollection {
	public static void main(String[] args) {
		List<String> strList = new ArrayList<String>();
		List<String> propList = new ArrayList<String>();
		strList.add("a");
		strList.add("b");
		strList.add("c");
		strList.add("d");
		strList.add("e");
		strList.add("f");
		strList.add("g");
		propList.add("c");
		propList.add("a");
		propList.add("k");
		propList.add("b");
		propList.add("t");
		propList.add("y");
		Set<String> propSet = new HashSet<String>();
		for(String p : propList) {
			if(strList.contains(p)) {
				strList.remove(p);
			}else {
				propSet.add(p);
			}
		}
		for (String s : strList) {
			System.out.println(s);
		}
		System.out.println("--------------------------");
		for (String s : propSet) {
			System.out.println(s);
		}
	}
}

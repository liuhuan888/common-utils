package com.liuhuan.common.utils.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import liuhuan.common.utils.DateUtil;

public class DateUtilTest {

	@Test
	public void dateUtilTest() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date initMonth = DateUtil.getDateByInitMonth(sdf.parse("2019-02-05 23:31:15"));
		System.out.println(initMonth);
		Date fullMonth = DateUtil.getDateByFullMonth(sdf.parse("2019-02-05 12:31:15"));
		System.out.println(fullMonth);
		String sql = "select * from t_order where create_time>='"+sdf.format(initMonth)+"' and create_time<='"+sdf.format(fullMonth)+"' ";
		System.out.println("sql="+sql);
	}
}

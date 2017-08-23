package com.lovo.conventer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConventer implements Converter<String,Date>{

	@Override
	public Date convert(String text) {
		// TODO Auto-generated method stub
		Date date = null;	
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sm.parse(text);
		/*	System.out.println("×ª»»³É¹¦");
			System.out.println(date);*/
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

}

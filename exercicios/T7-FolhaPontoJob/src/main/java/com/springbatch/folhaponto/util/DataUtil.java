package com.springbatch.folhaponto.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
	private static final SimpleDateFormat diaFormat = new SimpleDateFormat("dd/MM/yyy");
	private static final SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm");
	
	public static boolean isDatasMesmoDia(Date data1, Date data2) {
		return data1 != null && data2 != null && data1.getTime() == data2.getTime();
	}

	public static String formatDia(Date data) {
		return diaFormat.format(data);
	}

	public static String formatHoraDoDia(Date data) {
		return horaFormat.format(data);
	}
}

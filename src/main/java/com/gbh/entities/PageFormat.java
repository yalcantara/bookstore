package com.gbh.entities;

import static com.gbh.core.Utils.*;

public enum PageFormat {
	TEXT,
	HTML;


	public static String labelText(){
		StringBuilder sb = new StringBuilder();

		PageFormat[] values = values();
		for(int i =0; i < values.length; i++){
			sb.append(values[i].name());

			if(i + 1 < values.length){
				sb.append(", ");
			}
		}
				sb.append(']');

		return sb.toString();
	}

	public static PageFormat parse(String format){
		checkParamNotEmpty("format", format);

		format = format.trim().toUpperCase();

		for(PageFormat fmt:values()){
			if(fmt.name().equalsIgnoreCase(format)){
				return fmt;
			}
		}

		return null;
	}
}

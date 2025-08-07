package com.practice.wishGeneratorProject2.tools;

//import java.time.LocalDateTime;

import org.springframework.ai.tool.annotation.Tool;
//import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Tools {

//	 @Tool(description = "Get the current date and time in the user's timezone")
//	    String getCurrentDateTime() {
//	        return LocalDateTime.now().atZone(LocaleContextHolder.getTimeZone().toZoneId()).toString();
//	    }
	
	@Tool(name="test")
	public String studentInfo(Integer id, String name, String role) {
		return "welcome to our college";
	}
}

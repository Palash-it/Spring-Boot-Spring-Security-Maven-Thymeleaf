package com.palash.investment.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConstants {

	@Value("${app.title}")
	public String APP_TITLE;
}

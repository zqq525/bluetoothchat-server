package com.zqq;

import com.zqq.filter.LoginFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BluetoothchatServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BluetoothchatServerApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean loginFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		LoginFilter loginFilter = new LoginFilter();
		filterRegistrationBean.setFilter(loginFilter);
		filterRegistrationBean.addServletNames("loginFilter");
		List<String> url = new ArrayList<>();
		url.add("/");
		filterRegistrationBean.setUrlPatterns(url);
		return filterRegistrationBean;
	}
}

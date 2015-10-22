package io.github.web.thymeleaf;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class User {

	private String info;

	public void setInfo(String info) {
		this.info = info;
	}

	public String getInfo() {
		return info;
	}
}

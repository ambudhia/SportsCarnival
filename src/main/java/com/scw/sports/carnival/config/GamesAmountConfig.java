package com.scw.sports.carnival.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("carnival")
public class GamesAmountConfig {

	private Map<String, String> gameamount;

	public Map<String, String> getGameamount() {
		return gameamount;
	}

	public void setGameamount(Map<String, String> gameamount) {
		this.gameamount = gameamount;
	}

	

}

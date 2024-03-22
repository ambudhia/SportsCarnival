package com.scw.sports.carnival.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("carnival")
public class AllGamesConfig {

	private Map<String, String> games;

	public Map<String, String> getGames() {
		return games;
	}

	public void setGames(Map<String, String> games) {
		this.games = games;
	}

}

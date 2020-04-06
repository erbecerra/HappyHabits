package com.poke;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VersionDetailsItem{

	@JsonProperty("version")
	private Version version;

	@JsonProperty("rarity")
	private int rarity;

	public void setVersion(Version version){
		this.version = version;
	}

	public Version getVersion(){
		return version;
	}

	public void setRarity(int rarity){
		this.rarity = rarity;
	}

	public int getRarity(){
		return rarity;
	}

	@Override
 	public String toString(){
		return 
			"VersionDetailsItem{" + 
			"version = '" + version + '\'' + 
			",rarity = '" + rarity + '\'' + 
			"}";
		}
}
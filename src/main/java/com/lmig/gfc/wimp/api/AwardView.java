package com.lmig.gfc.wimp.api;


import com.lmig.gfc.wimp.models.Award;

public class AwardView {
	
	private Award award;
	
	public AwardView(Award award) {
		this.award = award;
	}
	public Long getId() {
		return award.getId();
	}
	public String getTitle() {
		return award.getTitle();
	}

	public String getOrganization() {
		return award.getOrganization();
	}
	
	public int getYear() {
		return award.getYear();
	}
//	public Actor getActor() {
//		return award.getActor();
//	}



}

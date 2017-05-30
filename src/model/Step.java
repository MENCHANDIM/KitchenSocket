package model;

import javax.sound.midi.VoiceStatus;

/**
 * 
 * A Step Class which contains a step description and a Uri of picture depicting the step. 
 * 
 * @author Wenbin Shi
 * 
 * @version 1.0
 * 
 * */

public class Step {
	
	private String stepDescription;
	
	private String picUri;
	
	/**
	 * Constructor to construct a Step object with step description and picUri.
	 * 
	 * @param stepDescription String. 
	 * 
	 * @param picUri uri which points to the picture.
	 * 
	 * @return null.
	 * 
	 * */
	
	public Step(String stepDescription, String picUri) {
		
		this.setStepDescription(stepDescription);
		
		this.setPicUri(picUri);
		
	}
	
	/**
	 * Edit a Step object with the new step description and picUri.
	 * 
	 * @param stepDescription String. 
	 * 
	 * @param picUri uri which points to the picture.
	 * 
	 * @return null.
	 * 
	 * */
	
	public void editStep(String stepDescription, String picUri){
				
		this.setStepDescription(stepDescription);
		
		this.setPicUri(picUri);
		
	}
	
	/**
	 * A static method to return a new Step object initialized by inputing step description and picUri.
	 * 
	 * @param stepDescription String. 
	 * 
	 * @param picUri uri which points to the picture.
	 * 
	 * @return Step. Return the created Step object for further operation.
	 * 
	 * */
	
	public static Step addStep(String stepDescription, String picUri){
		
		return new Step(stepDescription, picUri);
		
	}

	public String getStepDescription() {
		
		return stepDescription;
		
	}

	public void setStepDescription(String stepDescription) {
		
		this.stepDescription = stepDescription;
		
	}

	public String getPicUri() {
		
		return picUri;
		
	}

	public void setPicUri(String picUri) {
		
		this.picUri = picUri;
		
	}
	
	public String toString(){
		
		return stepDescription;
			
	}

}

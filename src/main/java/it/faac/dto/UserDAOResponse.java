package it.faac.dto;

public class UserDAOResponse
{
	private String error;
	private boolean isOkInsert;
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public boolean isOkInsert() {
		return isOkInsert;
	}
	public void setOkInsert(boolean isOkInsert) {
		this.isOkInsert = isOkInsert;
	}
	
	

}

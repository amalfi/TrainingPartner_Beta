package com.trainingpartner.models;

public class User 
{
		private Integer userId;
		private String login;
		private String password;
		private String userDescription;
		
		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getUserDescription() {
			return userDescription;
		}
		public void setUserDescription(String userDescription) {
			this.userDescription = userDescription;
		}
		
		
		
}
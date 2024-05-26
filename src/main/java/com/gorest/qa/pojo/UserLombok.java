package com.gorest.qa.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
public class UserLombok {
		
		@JsonProperty("name")
		private String name;
		
		@JsonProperty("gender")
		private String gender;
		
		@JsonProperty("email")
		private String email;
		
		@JsonProperty("status")
		private String status;
		
		public UserLombok(String name, String gender, String email, String status) {
			this.name = name;
			this.gender = gender;
			this.email = email;
			this.status = status;
		}
		

}
	
	


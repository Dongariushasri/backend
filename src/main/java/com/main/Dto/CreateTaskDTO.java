package com.main.Dto;

import lombok.Data;

@Data
public class CreateTaskDTO {
	   private Long id;
	    private Long projectId;
	    private Integer teamMemberId;
	    private String description;
	    private String status;
}

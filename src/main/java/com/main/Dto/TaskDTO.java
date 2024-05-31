package com.main.Dto;

public class TaskDTO {
    private Long id;
    private Long projectId;
    private String projectName;
    private Integer teamMemberId;
    private String teamMemberName;
    private String teamMemberEmail;
    private String description;
    private String status;

    // Getters and setters
    // You can generate these using your IDE or write them manually

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getTeamMemberId() {
        return teamMemberId;
    }

    public void setTeamMemberId(Integer teamMemberId) {
        this.teamMemberId = teamMemberId;
    }

    public String getTeamMemberName() {
        return teamMemberName;
    }

    public void setTeamMemberName(String teamMemberName) {
        this.teamMemberName = teamMemberName;
    }

    public String getTeamMemberEmail() {
        return teamMemberEmail;
    }

    public void setTeamMemberEmail(String teamMemberEmail) {
        this.teamMemberEmail = teamMemberEmail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

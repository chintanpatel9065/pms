package org.chintanpatel.pms.project;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.chintanpatel.pms.priority.Priority;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id", nullable = false)
    private Long projectId;

    @NotEmpty(message = "Please Provide Project Name")
    @Column(name = "project_name", nullable = false)
    private String projectName;

    @NotEmpty(message = "Please Provide Project Description")
    @Column(name = "description", nullable = false)
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Please Provide Project Start Date")
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Please Provide Project End Date")
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @ManyToOne
    @NotNull(message = "Please Select Project Priority")
    @JoinColumn(name = "priority_id", nullable = false)
    private Priority priority;

    public Project() {
    }

    public Project(Long projectId, String projectName, String description, LocalDate startDate, LocalDate endDate, Priority priority) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priority = priority;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}

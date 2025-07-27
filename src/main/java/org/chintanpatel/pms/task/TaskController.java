package org.chintanpatel.pms.task;

import jakarta.validation.Valid;
import org.chintanpatel.pms.project.Project;
import org.chintanpatel.pms.project.ProjectService;
import org.chintanpatel.pms.status.Status;
import org.chintanpatel.pms.status.StatusService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    private final TaskService taskService;
    private final ProjectService projectService;
    private final StatusService statusService;

    public TaskController(TaskService taskService, ProjectService projectService, StatusService statusService) {
        this.taskService = taskService;
        this.projectService = projectService;
        this.statusService = statusService;
    }

    @GetMapping("/tasks")
    public String listTask(Model model) {
        List<Task> taskList = taskService.getAllTaskList();
        model.addAttribute("taskList", taskList);
        return "task/task-list";
    }

    @GetMapping("/tasks/showTask")
    public String showTaskForm(Model model) {
        Task task = new Task();
        List<Project> projectList = projectService.getAllProjectList();
        List<Status> statusList = statusService.getStatusList();
        model.addAttribute("task", task);
        model.addAttribute("projectList", projectList);
        model.addAttribute("statusList", statusList);
        return "task/task-form";
    }

    @PostMapping("/tasks/insertOrUpdateTask")
    public String insertOrUpdateTask(@Valid @ModelAttribute("task") Task task, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<Project> projectList = projectService.getAllProjectList();
            List<Status> statusList = statusService.getStatusList();
            model.addAttribute("projectList", projectList);
            model.addAttribute("statusList", statusList);
            return "task/task-form";
        }
        taskService.addTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/manageTask/{taskId}")
    public String manageTask(@PathVariable Long taskId, Model model) {
        if (taskId != null) {
            Task task = taskService.getTaskById(taskId);
            List<Project> projectList = projectService.getAllProjectList();
            List<Status> statusList = statusService.getStatusList();
            model.addAttribute("task", task);
            model.addAttribute("projectList", projectList);
            model.addAttribute("statusList", statusList);
        }
        return "task/task-form";
    }

    @GetMapping("/tasks/deleteTask/{taskId}")
    public String deleteTask(@PathVariable Long taskId) {
        if (taskId != null) {
            taskService.deleteTaskById(taskId);
        }
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/search/taskName")
    public String searchByTaskName(@RequestParam("taskName")String taskName, Model model) {
        List<Task> taskList = taskService.searchByTaskName(taskName);
        model.addAttribute("taskList", taskList);
        model.addAttribute("taskName", taskName);
        model.addAttribute("searchType", "TaskName");
        return "task/task-list";
    }

    @GetMapping("/tasks/search/statusType")
    public String searchByStatusType(@RequestParam("statusType")String statusType, Model model) {
        List<Task> taskList = taskService.searchByStatusType(statusType);
        model.addAttribute("taskList", taskList);
        model.addAttribute("statusType", statusType);
        model.addAttribute("searchType", "StatusType");
        return "task/task-list";
    }

    @GetMapping("/tasks/search/projectName")
    public String searchByProjectName(@RequestParam("projectName")String projectName, Model model) {
        List<Task> taskList = taskService.searchByProjectName(projectName);
        model.addAttribute("taskList", taskList);
        model.addAttribute("projectName", projectName);
        model.addAttribute("searchType", "ProjectName");
        return "task/task-list";
    }
}

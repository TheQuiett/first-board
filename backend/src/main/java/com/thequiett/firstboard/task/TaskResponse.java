package com.thequiett.firstboard.task;

public record TaskResponse(String id, String title, String status, String label, String priority) {

    static TaskResponse from(Task task) {
        return new TaskResponse(
                "TASK-" + task.getId(), task.getTitle(), task.getStatus(), task.getLabel(), task.getPriority());
    }
}

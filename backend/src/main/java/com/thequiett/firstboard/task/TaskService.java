package com.thequiett.firstboard.task;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Transactional
    public TaskResponse create(TaskCreateRequest request) {
        Task task = Task.builder()
                .title(request.title())
                .status(request.status())
                .label(request.label())
                .priority(request.priority())
                .build();
        return TaskResponse.from(taskRepository.save(task));
    }

    @Transactional(readOnly = true)
    public List<TaskResponse> search(TaskSearchRequest request) {
        return taskMapper.search(request);
    }
}

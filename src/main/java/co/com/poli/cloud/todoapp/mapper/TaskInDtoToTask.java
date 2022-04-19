package co.com.poli.cloud.todoapp.mapper;

import co.com.poli.cloud.todoapp.persistence.entity.Task;
import co.com.poli.cloud.todoapp.persistence.entity.TaskStatus;
import co.com.poli.cloud.todoapp.services.dto.TaskInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskInDtoToTask implements IMapper<TaskInDTO, Task>{

    @Override
    public Task map(TaskInDTO in) {
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);
        return task;
    }
}

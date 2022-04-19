package co.com.poli.cloud.todoapp.services;

import co.com.poli.cloud.todoapp.exceptions.TodoExceptions;
import co.com.poli.cloud.todoapp.mapper.TaskInDtoToTask;
import co.com.poli.cloud.todoapp.persistence.entity.Task;
import co.com.poli.cloud.todoapp.persistence.entity.TaskStatus;
import co.com.poli.cloud.todoapp.persistence.repository.TaskRepository;
import co.com.poli.cloud.todoapp.services.dto.TaskInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;
    private final TaskInDtoToTask mapper;

    public Task createTask(TaskInDTO taskInDTO){
        Task task = mapper.map(taskInDTO);
        return this.repository.save(task);
    }

    public List<Task> findAll(){

        return this.repository.findAll();

    }

    public List<Task> findAllByTaskStatus(TaskStatus taskStatus){

        return this.repository.findAllByTaskStatus(taskStatus);

    }

    @Transactional
    public void updateTaskFinished(Long id) {

       Optional<Task> task = this.repository.findById(id);

        if(task.isEmpty()){

            throw new TodoExceptions("Task not found", HttpStatus.NOT_FOUND);

        }
        this.repository.markTaskAsFinished(id);

    }

    public void deleteById(Long id) {
        Optional<Task> task = this.repository.findById(id);
        if (task.isEmpty()) {
            throw new TodoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }

}

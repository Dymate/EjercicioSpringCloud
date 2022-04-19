package co.com.poli.cloud.todoapp.persistence.repository;

import co.com.poli.cloud.todoapp.persistence.entity.Task;
import co.com.poli.cloud.todoapp.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {


    List<Task> findAllByTaskStatus(TaskStatus taskStatus);

    @Modifying
    @Query(value = "UPDATE TASKS SET FINISHED=true WHERE ID=id",nativeQuery = true)
    void markTaskAsFinished(@Param("id") Long id);


}

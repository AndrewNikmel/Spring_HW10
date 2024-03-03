package Spring_HW.sem10.service;

import Spring_HW.sem10.module.Task;
import Spring_HW.sem10.module.TaskStatus;
import Spring_HW.sem10.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    //Репозиторий
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    //Перенаправление функции добавления в репозиторий
    public Task add(Task task) {
        return taskRepository.save(task);
    }
    //Запрос всех задач из репозитория
    public List<Task> findAll() {
        List<Task> tasks = new ArrayList<>();
        taskRepository.findAll().forEach(tasks::add);
        return tasks;
    }
    //Запрос задач по статусу
    public List<Task> getTaskByStatus(TaskStatus status) {
        return taskRepository.getTaskByStatus(status);
    }
    //Транзакция на обновление данных
    @Transactional
    public Task updateById(Long id, Task task) {
        taskRepository.updateTaskById(task.getShortDesc(), task.getDescription(), task.getStatus(), id);
        return taskRepository.findById(id).orElse(null);
    }
    //Удаление задачи по идентефикатору
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    public Task findById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }
}

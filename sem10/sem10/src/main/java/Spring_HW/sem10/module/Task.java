package Spring_HW.sem10.module;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Task {
    //Поля. Чуть увеличил структуру
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "short_description", nullable = false)
    private String shortDesc;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private TaskStatus status;
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime createTaskDate;

}

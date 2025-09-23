package ru.baymukhametov.FirstProject.dto;

public class StatTasks {
    private long totalTasks;
    private long completedTasks;
    private long incompleteTasks;
    private long overDueTasks;
}
//Этап 5. Статистика
//Реализуй эндпоинт /tasks/stats:
//должен вернуть JSON вида:
//        {
//        "totalTasks": 10,
//        "completedTasks": 6,
//        "incompleteTasks": 4,
//        "overdueTasks": 2
//        }

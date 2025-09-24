package ru.baymukhametov.FirstProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StatsTasksDto {
    private long totalTasks;
    private long completedTasks;
    private long incompleteTasks;
    private long overDueTasks;
}
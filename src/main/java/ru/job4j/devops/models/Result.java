package ru.job4j.devops.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO с результатов вычислений
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private double value;
}

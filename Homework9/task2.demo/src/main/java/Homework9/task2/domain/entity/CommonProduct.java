package Homework9.task2.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommonProduct implements Product{
    private int id;
    private String code;
    private String label;
    private double price;

}

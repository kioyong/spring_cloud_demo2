package com.yong.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Sequences {

    @Id
    private String id;
    private int number;

}

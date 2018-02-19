package com.yong.model;

import lombok.Data;

import java.util.List;

@Data
public class ActivitySession {

    private String id;
    private List<AmountChangeTracker> fills;
    private List<AmountChangeTracker> credits;

}

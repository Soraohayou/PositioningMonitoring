package com.soraohayou.positioningmonitoring.entity;

import lombok.Data;

@Data
public class TrajectoryRecording {

    private String Id;
    private double Abscissa;
    private double Ordinate;
    private String PositionTime;
    private String PositionUserId;
    private String TeamId;
}

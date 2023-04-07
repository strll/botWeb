package com.entity.WebEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebTodayEat {
    private Integer id;

    private String message;

    private String qq;


    private String url;

    private boolean show=false;

}

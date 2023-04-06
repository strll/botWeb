package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class userPage {
    private List<AppUser> appUserList;
    private String appUserlength; //一共有多少页

}

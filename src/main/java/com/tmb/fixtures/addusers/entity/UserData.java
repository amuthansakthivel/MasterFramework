package com.tmb.fixtures.addusers.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Builder
public class UserData {

  private String userRole;
  private String employeeName;
  private String userName;
  private String status;
  private String password;
  private String message;

}

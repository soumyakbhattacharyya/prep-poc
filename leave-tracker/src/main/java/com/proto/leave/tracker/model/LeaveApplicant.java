package com.proto.leave.tracker.model;

import java.util.Map;

import lombok.Data;

@Data
public class LeaveApplicant {

  private String firstName;
  private String lastName;

  private Department department;
  private String phoneNumber;

  public Leave apply(LeaveApplicationRequest leaveApplicationRequest) {
    return null;
  }

  public Map<LeaveCategory, Integer> balance() {
    return null;

  }

}

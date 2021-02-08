package com.proto.leave.tracker.model;

public class LeaveApprover extends LeaveApplicant {

  public LeaveStatus act(Leave leave) {
    return LeaveStatus.REJECTED;

  }
}

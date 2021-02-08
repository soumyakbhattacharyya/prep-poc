package com.proto.leave.tracker.model;

import java.util.Date;

import lombok.Builder;

@Builder
public class LeaveApplicationRequest {
  
  /**
   * assumption is there can be no half day leaves
   */
  private Date from;
  private Date to;
  
  private String purpose;

}

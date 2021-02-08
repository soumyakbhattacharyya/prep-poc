package com.proto.leave.tracker.model;

import java.util.Date;

import lombok.Data;

@Data
public class Leave {
  
  /**
   * assumption is there can be no half day leaves
   */
  private Date from;
  private Date to;
  
  private String purpose;
  
  /**
   * if this is a leave scheduled to be take in future
   */
  private boolean scheduled;
  private LeaveStatus leaveStatus;
  
  

}

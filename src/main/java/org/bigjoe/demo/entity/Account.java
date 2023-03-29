package org.bigjoe.demo.entity;

/**
* 由脚本自动生成
* @Date: 2023-03-29 16:35:20
*/

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "account")
@Data 
public class Account {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    private java.util.Date created_at;
    private java.util.Date updated_at;
    private Long accountId;
    private Integer status;
    private String statusStr;
    private Integer accountType;
    private Integer parentId;
    private Long parentAccountId;
    private String name;
    private Integer clicks;
    private Integer impressions;
    private String dateStart;
    private String dateStop;
    private Integer disableReason;
    private java.math.BigDecimal spendCap;
    private java.math.BigDecimal spend;
    private java.math.BigDecimal balance;
    private String currency;
    private Integer reach;
    private String timeZone;
    private Integer bindStatus;
    private java.util.Date bind_at;
    private Integer mtUserId;
    private Integer gaProjectId;
    private String accessToken;
    private String latestSyncDate0;
    private String latestSyncDate1;
    private String latestSyncDate2;
    private String latestSyncDate3;
    private Integer orgId;
    private Integer adminUserId;
    private Integer getReport;

}
package com.opencode.bean;

import java.util.Date;


/**
 * AbstractTspWorkMessage generated by MyEclipse - Hibernate Tools
 */

public abstract class AbstractTspWorkMessage  implements java.io.Serializable {


    // Fields    

     private Long messId;
     private String messTitle;
     private String messContent;
     private String messFlag;
     private String messIsStaste;
     private String messIncUser;
     private String messAppUser;
     private Date messAppDate;
     private String messDeptCode;
     private String messTableCode;
     private Long messTableId;


    // Constructors

    /** default constructor */
    public AbstractTspWorkMessage() {
    }

	/** minimal constructor */
    public AbstractTspWorkMessage(Long messId, String messTitle, String messFlag, String messIsStaste, String messIncUser, String messAppUser, Date messAppDate, String messDeptCode, String messTableCode, Long messTableId) {
        this.messId = messId;
        this.messTitle = messTitle;
        this.messFlag = messFlag;
        this.messIsStaste = messIsStaste;
        this.messIncUser = messIncUser;
        this.messAppUser = messAppUser;
        this.messAppDate = messAppDate;
        this.messDeptCode = messDeptCode;
        this.messTableCode = messTableCode;
        this.messTableId = messTableId;
    }
    
    /** full constructor */
    public AbstractTspWorkMessage(Long messId, String messTitle, String messContent, String messFlag, String messIsStaste, String messIncUser, String messAppUser, Date messAppDate, String messDeptCode, String messTableCode, Long messTableId) {
        this.messId = messId;
        this.messTitle = messTitle;
        this.messContent = messContent;
        this.messFlag = messFlag;
        this.messIsStaste = messIsStaste;
        this.messIncUser = messIncUser;
        this.messAppUser = messAppUser;
        this.messAppDate = messAppDate;
        this.messDeptCode = messDeptCode;
        this.messTableCode = messTableCode;
        this.messTableId = messTableId;
    }

   
    // Property accessors

    public Long getMessId() {
        return this.messId;
    }
    
    public void setMessId(Long messId) {
        this.messId = messId;
    }

    public String getMessTitle() {
        return this.messTitle;
    }
    
    public void setMessTitle(String messTitle) {
        this.messTitle = messTitle;
    }

    public String getMessContent() {
        return this.messContent;
    }
    
    public void setMessContent(String messContent) {
        this.messContent = messContent;
    }

    public String getMessFlag() {
        return this.messFlag;
    }
    
    public void setMessFlag(String messFlag) {
        this.messFlag = messFlag;
    }

    public String getMessIsStaste() {
        return this.messIsStaste;
    }
    
    public void setMessIsStaste(String messIsStaste) {
        this.messIsStaste = messIsStaste;
    }

    public String getMessIncUser() {
        return this.messIncUser;
    }
    
    public void setMessIncUser(String messIncUser) {
        this.messIncUser = messIncUser;
    }

    public String getMessAppUser() {
        return this.messAppUser;
    }
    
    public void setMessAppUser(String messAppUser) {
        this.messAppUser = messAppUser;
    }

    public Date getMessAppDate() {
        return this.messAppDate;
    }
    
    public void setMessAppDate(Date messAppDate) {
        this.messAppDate = messAppDate;
    }

    public String getMessDeptCode() {
        return this.messDeptCode;
    }
    
    public void setMessDeptCode(String messDeptCode) {
        this.messDeptCode = messDeptCode;
    }

    public String getMessTableCode() {
        return this.messTableCode;
    }
    
    public void setMessTableCode(String messTableCode) {
        this.messTableCode = messTableCode;
    }

    public Long getMessTableId() {
        return this.messTableId;
    }
    
    public void setMessTableId(Long messTableId) {
        this.messTableId = messTableId;
    }
   








}
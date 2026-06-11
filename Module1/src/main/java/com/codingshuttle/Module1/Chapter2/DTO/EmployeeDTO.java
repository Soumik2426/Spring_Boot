package com.codingshuttle.Module1.Chapter2.DTO;

import java.time.LocalDate;

public class EmployeeDTO {
    private Long Id;
    private String First_Name;
    private String Last_Name;
    private String Email;
    private String Phn_Number;
    private LocalDate Joinig_Date;
    private Boolean Active;

    public EmployeeDTO(Long Id, String First_Name, String Last_Name, String Email, String Phn_Number, LocalDate Joinig_Date, Boolean Active) {
        this.Id = Id;
        this.First_Name = First_Name;
        this.Last_Name = Last_Name;
        this.Email = Email;
        this.Phn_Number = Phn_Number;
        this.Joinig_Date = Joinig_Date;
        this.Active = Active;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhn_Number() {
        return Phn_Number;
    }

    public void setPhn_Number(String phn_Number) {
        Phn_Number = phn_Number;
    }

    public LocalDate getJoinig_Date() {
        return Joinig_Date;
    }

    public void setJoinig_Date(LocalDate joinig_Date) {
        Joinig_Date = joinig_Date;
    }

    public Boolean getActive() {
        return Active;
    }

    public void setActive(Boolean active) {
        Active = active;
    }
}

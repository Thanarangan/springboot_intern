package com.example.springbootfirst.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@Table(name = "user_details")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RegisterDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int empId;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String password;

  @Column(name = "user_name", nullable = false, unique = true)
  private String userName;

  @Column(nullable = false)
  private String address;

  @Temporal(TemporalType.DATE)
  private Date dob;

  @Column(nullable = false)
  private String fatherName;

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(
          name = "user_roles",
          joinColumns = @JoinColumn(name = "user_id1", referencedColumnName = "empId"),
          inverseJoinColumns = @JoinColumn(name = "roles_id", referencedColumnName = "roleId")
  )
  private Set<Roles> roles;

  public int getEmpId() {
    return empId;
  }

  public void setEmpId(int empId) {
    this.empId = empId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Date getDob() {
    return dob;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }

  public String getFatherName() {
    return fatherName;
  }

  public void setFatherName(String fatherName) {
    this.fatherName = fatherName;
  }

  public Set<Roles> getRoles() {
    return roles;
  }

  public void setRoles(Set<Roles> roles) {
    this.roles = roles;
  }
}

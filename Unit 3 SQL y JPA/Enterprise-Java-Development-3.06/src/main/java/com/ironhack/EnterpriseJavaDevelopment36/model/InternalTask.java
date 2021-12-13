package com.ironhack.EnterpriseJavaDevelopment36.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class InternalTask extends Task {

}

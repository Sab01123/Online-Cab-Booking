package com.cabBooking.models;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="adminId")
public class Admin extends Abstractuser {

	
	
}

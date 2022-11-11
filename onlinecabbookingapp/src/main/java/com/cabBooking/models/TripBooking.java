package com.cabBooking.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TripBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tripBookingId;
	private Integer customerId;

	@ManyToOne
	private Driver driver;
	private String fromLocation;
	private String toLocation;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime fromDateTime;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime toDateTime;
	private boolean status;
	private Float distanceInKm;
	private Float bill;

}

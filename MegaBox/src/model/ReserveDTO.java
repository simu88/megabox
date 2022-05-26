package model;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import com.sun.jmx.snmp.Timestamp;

public class ReserveDTO {

	int customer_id;
	int schedule_id;
	LocalDate date;
	String creditcard;
	String payment_type;
	LocalDateTime reserve_time;
	int customer_count;
	int price_sum;

	
	public ReserveDTO(int customer_id, int schedule_id, LocalDate date, String creditcard, String payment_type,
			LocalDateTime reserve_time, int customer_count, int price_sum) 
	{
		this.customer_id=customer_id;
		this.schedule_id=schedule_id;
		this.date=date;
		this.creditcard=creditcard;
		this.payment_type=payment_type;
		this.reserve_time=reserve_time;
		this.customer_count=customer_count;
		this.price_sum=price_sum;

	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id=customer_id;
	}
	
	public int getSchedule_id() {
		return schedule_id;
	}

	public void setSchedule_id(int schedule_id) {
		this.schedule_id=schedule_id;
	}
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date=date;
	}
	
	public String getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(String creditcard) {
		this.creditcard=creditcard;
	}
	
	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type=payment_type;
	}
	
	public LocalDateTime getReserve_time() {
		return reserve_time;
	}

	public void setReserve_time(LocalDateTime reserve_time) {
		this.reserve_time=reserve_time;
	}
	
	public int getCustomer_count() {
		return customer_count;
	}

	public void setCustomer_count(int customer_count) {
		this.customer_count=customer_count;
	}
	
	public int getPrice_sum() {
		return price_sum;
	}

	public void setPrice_sum(int price_sum) {
		this.price_sum=price_sum;
	}
}

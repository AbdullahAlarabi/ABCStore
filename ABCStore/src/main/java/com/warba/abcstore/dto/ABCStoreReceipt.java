package com.warba.abcstore.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;


@Component
@ApiModel(description = "ABCStoreReceipt Model")
public class ABCStoreReceipt implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4653965282553945715L;
	
	private double totalAmountBeforeDiscout;
	private double totalAmountAfterDiscout;
	private double totalAmountDisconut;
	
	public double getTotalAmountBeforeDiscout() {
		return totalAmountBeforeDiscout;
	}
	public void setTotalAmountBeforeDiscout(double totalAmountBeforeDiscout) {
		this.totalAmountBeforeDiscout = totalAmountBeforeDiscout;
	}
	public double getTotalAmountAfterDiscout() {
		return totalAmountAfterDiscout;
	}
	public void setTotalAmountAfterDiscout(double totalAmountAfterDiscout) {
		this.totalAmountAfterDiscout = totalAmountAfterDiscout;
	}
	public double getTotalAmountDisconut() {
		return totalAmountDisconut;
	}
	public void setTotalAmountDisconut(double totalAmountDisconut) {
		this.totalAmountDisconut = totalAmountDisconut;
	}
	
	
	
     
	
	
	
}

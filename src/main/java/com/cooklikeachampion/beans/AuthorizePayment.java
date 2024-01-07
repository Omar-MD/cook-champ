package com.cooklikeachampion.beans;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.cooklikeachampion.models.OrderDetail;
import com.cooklikeachampion.utils.PaymentServices;
//import com.paypal.base.rest.PayPalRESTException;
import com.paypal.base.rest.PayPalRESTException;

@ManagedBean
@SessionScoped
public class AuthorizePayment {
	private static String product = "Student Booking";
	private static float subTotal = 45.0f ,shipping  = 0.0f, tax  = 0.0f, total  = 45.0f;
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		AuthorizePayment.product = product;
	}
	public float getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(float subTotal) {
		AuthorizePayment.subTotal = subTotal;
	}
	public float getShipping() {
		return shipping;
	}
	public void setShipping(float shipping) {
		AuthorizePayment.shipping = shipping;
	}
	public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
		AuthorizePayment.tax = tax;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		AuthorizePayment.total = total;
	}

	public static String checkOut() throws IOException{
		try {
			OrderDetail orderDetail = new OrderDetail(product, subTotal, shipping, tax, total);
            PaymentServices paymentServices = new PaymentServices();
            String approvalLink = paymentServices.authorizePayment(orderDetail);
            FacesContext.getCurrentInstance().
            getExternalContext().redirect(approvalLink);
        } catch (PayPalRESTException ex) {
        	ex.printStackTrace();
        }
		return null;
	}


}

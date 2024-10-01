package uas;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Transaction {
	private String idTransaction, Status;
	private Date dateNow;
	public String getIdTransaction() {
		return idTransaction;
	}
	public String getStatus() {
		return Status;
	}
	public Date getDateNow() {
		return dateNow;
	}
	public void setIdTransaction(String idTransaction) {
		this.idTransaction = idTransaction;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public void setDateNow(Date dateNow) {
		this.dateNow = dateNow;
	}
	public Transaction(String status) {
		this.Status = status;
		this.dateNow = new Date();
	}
	public void generateId()
	{
		Random rand = new Random();
		Integer random = rand.nextInt(10000);
		idTransaction = "T".concat(Integer.toString(random));
	}
	public void display() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String formattedDate = dateFormat.format(dateNow);
		System.out.println(idTransaction + " "+ Status + " "+ formattedDate );
	}
}

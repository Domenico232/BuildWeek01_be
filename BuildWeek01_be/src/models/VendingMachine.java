package models;

import java.util.List;

import enumerates.TypeReseller;

public class VendingMachine extends Reseller {
		
	private TypeReseller typeReseller;

	public VendingMachine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VendingMachine(Integer id, String name, List<Ticket> ticketSell, TypeReseller typeReseller) {
		super(id, name, ticketSell);
		this.typeReseller = typeReseller;
	}

	public VendingMachine(String name, List<Ticket> ticketSell, TypeReseller typeReseller) {
		super(name, ticketSell);
		this.typeReseller = typeReseller;
	}

	public TypeReseller getTypeReseller() {
		return typeReseller;
	}

	public void setTypeReseller(TypeReseller typeReseller) {
		this.typeReseller = typeReseller;
	}

	@Override
	public String toString() {
		return super.toString() + "VendingMachine [typeReseller=" + typeReseller + "]";
	}
	
	
	
}

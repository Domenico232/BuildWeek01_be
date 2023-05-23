package models;

import enumerates.TypeReseller;

public class VendingMachine extends Reseller {
		
	private TypeReseller typeReseller;

	public VendingMachine() {
		super();
	}

	public VendingMachine(Integer id, String name, TypeReseller typeReseller) {
		super(id, name);
		this.typeReseller = typeReseller;
	}

	public VendingMachine(String name, TypeReseller typeReseller) {
		super(name);
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

package models;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import enumerates.TypeVendingMachine;

@Entity
@Table(name = "vending_machines")
public class VendingMachine extends Reseller {

	@Enumerated(EnumType.STRING)
	private TypeVendingMachine typeVendingMachine;

	public VendingMachine() {
		super();
	}

	public VendingMachine(Integer id, String name, TypeVendingMachine typeVendingMachine) {
		super(id, name);
		this.typeVendingMachine = typeVendingMachine;
	}

	public VendingMachine(String name, TypeVendingMachine typeVendingMachine) {
		super(name);
		this.typeVendingMachine = typeVendingMachine;
	}

	public TypeVendingMachine getTypeVendingMachine() {
		return typeVendingMachine;
	}

	public void setTypeVendingMachine(TypeVendingMachine typeVendingMachine) {
		this.typeVendingMachine = typeVendingMachine;
	}

	public void activate() {
		this.typeVendingMachine = TypeVendingMachine.ACTIVE;
	}

	public void deactivate() {
		this.typeVendingMachine = TypeVendingMachine.OUT_OF_SERVICE;
	}

	public boolean isActive() {
		return this.getTypeVendingMachine().equals(TypeVendingMachine.ACTIVE) ? true : false;
	}

	@Override
	public String toString() {
		return "VendingMachine [id=" + super.getId() + ", name=" + super.getName() + ", typeVendingMachine=" + typeVendingMachine + "]";
	}

	public static VendingMachine randomVendingMachine() {
		Random random = new Random();
		String[] names = { "Vending Machine A", "Vending Machine B", "Vending Machine C" };
		String name = names[random.nextInt(names.length)];
		TypeVendingMachine type = TypeVendingMachine.values()[random.nextInt(TypeVendingMachine.values().length)];
		return new VendingMachine(name, type);
	}

}

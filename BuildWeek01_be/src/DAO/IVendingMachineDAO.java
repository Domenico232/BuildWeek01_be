package DAO;

import java.util.List;

import models.VendingMachine;

public interface IVendingMachineDAO {
	public  void save(VendingMachine vm);
	public void delete(Long id);
	public VendingMachine getById(Long id);
	public void update(VendingMachine vm);
	 public List<VendingMachine> getAll();
}

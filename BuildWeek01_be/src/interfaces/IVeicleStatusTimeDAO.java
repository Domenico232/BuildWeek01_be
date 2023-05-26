package interfaces;

import java.util.List;

import models.VeicleStatusTime;

public interface IVeicleStatusTimeDAO {

    void save(VeicleStatusTime veicleStatusTime);

    void saveAll(List<VeicleStatusTime> veicleStatusTimes);

    VeicleStatusTime getById(long id);

    void update(VeicleStatusTime veicleStatusTime);

    void remove(VeicleStatusTime veicleStatusTime);

    List<VeicleStatusTime> getAll();
}

package ru.mtuci.simpleapi.service;

import ru.mtuci.simpleapi.model.Computers;

import java.util.List;

public interface ComputersService {

    Computers get(Long id);

    List<Computers> getAll();

    Computers save(Computers computers);

    void delete(Long id);

}

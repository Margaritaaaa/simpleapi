package ru.mtuci.simpleapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mtuci.simpleapi.dao.ComputerRepository;
import ru.mtuci.simpleapi.model.Computers;

import java.util.List;

@Service
public class ComputersServiceImpl implements ComputersService {

    private final ComputerRepository computerRepository;

    @Autowired
    public ComputersServiceImpl(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    @Override
    public Computers get(Long id) {
        return computerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Computers> getAll() {
        return computerRepository.findAll();
    }

    @Override
    public Computers save(Computers computers) {
        return computerRepository.save(computers);
    }

    @Override
    public void delete(Long id) {
        computerRepository.delete(id);
    }
}

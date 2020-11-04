package ru.mtuci.simpleapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.mtuci.simpleapi.dao.ComputerRepository;
@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final ComputerRepository computerRepository;

    @Autowired
    public CommandLineAppStartupRunner(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    @Override
    public void run(String...args) throws Exception {
       // System.out.println(computerRepository.findById(2L).get()); //переменная типа long -> окончание 1L
    }
}



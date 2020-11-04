package ru.mtuci.simpleapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.mtuci.simpleapi.model.Computers;
import ru.mtuci.simpleapi.service.ComputersService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = ComputersController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ComputersController {
    public static final String REST_URL = "/api/v1/computers";

    private final ComputersService computersService;

    @Autowired
    public ComputersController(ComputersService computersService) {
        this.computersService = computersService;
    }

    @GetMapping(value = "/{id}")
    public Computers get(@PathVariable("id") Long id) { //на вход конкретный параметр
        log.info("get " + id);
        return computersService.get(id);
    }

    @GetMapping
    public List<Computers> getAll() {
        log.info("getAll");
        return computersService.getAll();
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE) //принимаем json
    public Computers save(@RequestBody Computers computers) {
        log.info("save " + computers);
        return computersService.save(computers);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        log.info("delete " + id);
        computersService.delete(id);
    }
}

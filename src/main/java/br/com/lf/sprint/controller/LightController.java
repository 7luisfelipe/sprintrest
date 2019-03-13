package br.com.lf.sprint.controller;

import br.com.lf.sprint.repository.LightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("light")
public class LightController {
    private final LightRepository lightRepository;

    @Autowired
    public LightController(LightRepository lightRepository) {
        this.lightRepository = lightRepository;
    }

    @GetMapping(path = "user/lights")
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(lightRepository.findAll(), HttpStatus.OK);
    }
}

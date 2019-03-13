package br.com.lf.sprint.controller;

import br.com.lf.sprint.model.OpenLight;
import br.com.lf.sprint.repository.OpenLightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/open")
public class OpenLightController {
    private OpenLightRepository repository;

    @Autowired
    public void setRepository(OpenLightRepository repository) {
        this.repository = repository;
    }

    @PutMapping("user/light/{nLight}")
    public ResponseEntity<OpenLight> openLight(@Valid @PathVariable("nLight") int nLight){
        OpenLight ol = repository.findById(1l);
        ol.setLight(nLight);

        repository.save(ol);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package controller;

import model.patrol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.lswService;

import java.util.List;

@RestController
@RequestMapping("/lsw")
public class patrolController {
    @Autowired
    private lswService service;

    public patrolController(lswService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<patrol> getAllPatrols() {
        return service.getPatrols();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public patrol getPatrolById(@PathVariable Integer id) {
        return service.getPatrol(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addPatrol(@RequestBody patrol patrol) {
        service.addPatrol(patrol);
    }


}

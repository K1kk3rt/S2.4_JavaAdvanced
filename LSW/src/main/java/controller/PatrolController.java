package controller;

import model.Patrol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.LswService;

import java.util.List;

@RestController
@RequestMapping("/lsw")
public class PatrolController {
    @Autowired
    private LswService service;

    public PatrolController(LswService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Patrol> getAllPatrols() {
        return service.getPatrols();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Patrol getPatrolById(@PathVariable Integer id) {
        return service.getPatrol(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addPatrol(@RequestBody Patrol patrol) {
        service.addPatrol(patrol);
    }

    @RequestMapping(value = "minPoints/{points}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Patrol> getPatrolsByMinPoints(@PathVariable Integer points) {
        return service.getPatrolsByMinPoints(true, points, 100);
    }


}

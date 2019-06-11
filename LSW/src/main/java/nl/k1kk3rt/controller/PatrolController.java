package nl.k1kk3rt.controller;

import nl.k1kk3rt.model.Patrol;
import nl.k1kk3rt.service.LswService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patrols")
public class PatrolController {

    private LswService service;

    //private static final Logger logger = Logger.getLogger(App.class.getName());

    public PatrolController(LswService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Patrol> getAllPatrols() {
        return service.getAllPatrols();
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addPatrol(@RequestBody Patrol patrol) {
        service.addPatrol(patrol);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Patrol getPatrolById(@PathVariable Long id) {

        return service.getPatrolById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deletePatrol(@PathVariable Long id) {
        service.deletePatrol(id);
    }
}

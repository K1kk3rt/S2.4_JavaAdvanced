package nl.k1kk3rt.controller;

import nl.k1kk3rt.model.Points;
import nl.k1kk3rt.service.LswService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/points")
public class PointsController {

    private LswService service;

    public PointsController(LswService service) {
        this.service = service;
    }

    @RequestMapping(value = "value/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer getPatrolPointsById(@PathVariable Long id) {
        return service.getPatrolPointsById(id);
    }

    @RequestMapping(value ="{id}", method = RequestMethod.DELETE)
    public void deletePoints(@PathVariable Long id) {
        service.deletePatrol(id);
    }

    @RequestMapping(value ="", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Points> getAllPoints() {
        return service.getAllPoints();
    }
}


package dev.eugenie.controller;

import dev.eugenie.model.Rsw;
import dev.eugenie.service.RswGroupService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rsw")
public class RswController {
    private RswGroupService service;

    public RswController(RswGroupService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Rsw> getAllGroups() {
        return service.getGroups();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Rsw getGroupById(@PathVariable Integer id) {
        return service.getGroup(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addGroup(@RequestBody Rsw group) {
        service.addGroup(group);
    }

}

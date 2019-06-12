package nl.inholland.controller;

import nl.inholland.App;
import nl.inholland.model.Numbers;
import nl.inholland.service.NumberService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/question2")
public class NumberController {

    private NumberService service;

    public NumberController(NumberService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Numbers> getAllNumbers() {
        return service.getNumbers();

    }

}

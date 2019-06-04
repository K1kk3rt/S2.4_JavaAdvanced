package service;

import model.patrol;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class lswService {
    private List<patrol> patrols = new ArrayList<patrol>(
            Arrays.asList(
                    new patrol(1, 9580, 21, "De Vliegende Schotels", "Hengelo", "Scouting Hendrik Hudson"),
                    new patrol(2, 9337, 1, "Professor Pruttel en Co", "Leiden", "Franciscusgroep Leiden"),
                    new patrol(3, 8421, 109, "Be B-VII", "Hengelo", "Cunera-St. Marcellinus")
            )
    );

    public List<patrol> getPatrols() {
        return patrols;
    }

    public patrol getPatrol(Integer id) {
        for (patrol patrol : patrols) {
            if (patrol.getId().equals(id)) {
                return patrol;
            }
        }
        return null;
    }

    public void addPatrol(patrol patrol) {
        patrols.add(patrol);
    }

}

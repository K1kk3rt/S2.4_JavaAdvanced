package service;

import model.Patrol;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.stream.Stream;

@Service
public class LswService {
    private List<Patrol> patrols = new ArrayList<Patrol>(
            Arrays.asList(
                    new Patrol(1, 9580, 21, "De Vliegende Schotels", "Hengelo", "Scouting Hendrik Hudson"),
                    new Patrol(2, 9337, 1, "Professor Pruttel en Co", "Leiden", "Franciscusgroep Leiden"),
                    new Patrol(3, 8421, 109, "Be B-VII", "Hengelo", "Cunera-St. Marcellinus")
            )
    );

    public List<Patrol> getPatrolsByMinPoints(boolean sorted, int minimumPoints, int pageSize) {
        Stream<Patrol> patrolStream = patrols.stream()
                .filter(patrol -> patrol.getPoints() >= minimumPoints);

        if (sorted) {
            patrolStream = patrolStream.sorted(Comparator.comparingInt(Patrol::getPoints).reversed());
        }

        return patrolStream
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    public List<Patrol> getPatrols() {
        return patrols;
    }

    public Patrol getPatrol(Integer id) {
        return patrols.stream()
                .filter(patrol -> patrol.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addPatrol(Patrol patrol) {
        patrols.add(patrol);
    }

}

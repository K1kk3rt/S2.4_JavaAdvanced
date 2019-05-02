package dev.eugenie.service;

import dev.eugenie.model.Rsw;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RswGroupService {

    private List<Rsw> groups = new ArrayList<>(
            Arrays.asList(
                    new Rsw(1, "HemelsBlauw", 247),
                    new Rsw(2, "B-Bravo", 229),
                    new Rsw(3, "E-Echo", 208)
            )
    );

    public List<Rsw> getGroups() {
        return groups;
    }

    public Rsw getGroup(Integer id) {
        for (Rsw group : groups) {
            if (group.getId().equals(id)) {
                return group;
            }
        }
        return null;
    }

    public void addGroup(Rsw group) {
        groups.add(group);
    }

}

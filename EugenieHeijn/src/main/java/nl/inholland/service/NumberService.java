package nl.inholland.service;

import nl.inholland.model.Numbers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class NumberService {
    List<Numbers> numbers = new ArrayList<>(
            Arrays.asList(
                    new Numbers(1),
                    new Numbers(2),
                    new Numbers(3),
                    new Numbers(4),
                    new Numbers(5),
                    new Numbers(6),
                    new Numbers(7),
                    new Numbers(8),
                    new Numbers(9),
                    new Numbers(10)
            )
    );

    public List<Numbers> getNumbers() {
        return numbers;
    }
}

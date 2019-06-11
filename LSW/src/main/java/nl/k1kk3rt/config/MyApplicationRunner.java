package nl.k1kk3rt.config;


import nl.k1kk3rt.model.Patrol;
import nl.k1kk3rt.model.Points;
import nl.k1kk3rt.repository.PatrolRepository;
import nl.k1kk3rt.repository.PointsRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    private PatrolRepository patrolRepository;
    private PointsRepository pointsRepository;

    public MyApplicationRunner(PatrolRepository patrolRepositoryRepository, PointsRepository pointsRepository) {
        this.patrolRepository = patrolRepositoryRepository;
        this.pointsRepository = pointsRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Patrol pattrol = new Patrol( "joe");

        Files.lines(Paths.get("src/main/resources/patrols.csv"))
                .forEach(
                        line -> pointsRepository.save(
                                new Points(pattrol
                                        ,
                                        Integer.parseInt(line.split(",")[1])
                                )));

//        new Patrol(
//                line.split(",")[0]
//        )

        pointsRepository.findAll()
                .forEach(System.out::println);

        List<Patrol> patrols = (List<Patrol>) patrolRepository.findAll();
        patrols.stream()
                .forEach(a -> pointsRepository.save(new Points(a, new Random().nextInt(10))));

        pointsRepository.findAll()
                .forEach(System.out::println);
    }


}


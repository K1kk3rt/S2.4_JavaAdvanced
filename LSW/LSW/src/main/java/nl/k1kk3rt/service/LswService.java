package nl.k1kk3rt.service;

import nl.k1kk3rt.model.Patrol;
import nl.k1kk3rt.model.Points;
import nl.k1kk3rt.repository.PatrolRepository;
import nl.k1kk3rt.repository.PointsRepository;
import org.springframework.stereotype.Service;

@Service
public class LswService {

    private PatrolRepository patrolRepository;
    private PointsRepository pointsRepository;



    public LswService(PatrolRepository patrolRepository, PointsRepository pointsRepository) {
        this.patrolRepository = patrolRepository;
        this.pointsRepository = pointsRepository;
    }

    public Iterable<Patrol> getAllPatrols() {
        return patrolRepository.findAll();
    }

    public void addPatrol(Patrol patrol) {
        patrolRepository.save(patrol);
    }

    public void deletePatrol(Long id) {
        pointsRepository.delete(pointsRepository.findById(id).orElseThrow(IllegalArgumentException::new));
        patrolRepository.delete(patrolRepository.findById(id).orElseThrow(IllegalArgumentException::new));
    }

    public Integer getPatrolPointsById(Long id) {
        return pointsRepository.getPatrolPointsById(id);
    }

    public Iterable<Points> getAllPoints() {
        return pointsRepository.findAll();
    }

    public Patrol getPatrolById(Long id) {
        return patrolRepository.findById(id).orElseThrow(IllegalArgumentException::new);

    }
}


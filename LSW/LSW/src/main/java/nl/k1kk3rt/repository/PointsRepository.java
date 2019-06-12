package nl.k1kk3rt.repository;

import nl.k1kk3rt.model.Points;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PointsRepository extends CrudRepository<Points, Long> {

    //@Query("select p.id, p.groupName, s.points, s.id from Points s, Patrol p where s.patrol.id = p.id and s.patrol.id = ?1")
    @Query("SELECT points FROM Points WHERE id = ?1")
    public int getPatrolPointsById(Long id);
}


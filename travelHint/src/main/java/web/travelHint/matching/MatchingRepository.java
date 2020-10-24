package web.travelHint.matching;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MatchingRepository extends JpaRepository<Matching, Long>, JpaSpecificationExecutor<Matching> {

    Matching findById(long id);
}

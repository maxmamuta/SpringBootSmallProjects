package testnosql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import testnosql.domain.Journal;

import java.util.List;

/**
 * Created by maxmamuta on 9/15/17.
 */
public interface JournalRepository extends MongoRepository<Journal, String> {
    public List<Journal> findByTitleLike(String word);
}

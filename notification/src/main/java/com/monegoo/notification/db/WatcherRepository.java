package com.monegoo.notification.db;

import com.monegoo.notification.db.entity.Watcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface WatcherRepository extends JpaRepository<Watcher, Integer> {

    @Transactional
    Integer deleteByUser(Integer user);


    @Query(value = "from Watcher where enabled = true order by lastVerified asc limit 10")
    List<Watcher> getUnprocessed();

    List<Watcher> findByUser(Integer id);

    Optional<Watcher> findByUserAndId(Integer userId, Integer id);

}

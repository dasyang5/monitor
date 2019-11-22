package com.nl.monitor.repository;

import com.nl.monitor.entity.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Alex
 * @date 2019/11/15 10:40
 */
@Repository
public interface MonitorRepository extends JpaRepository<Monitor, String> {

    @Query(value = "select id,title from Monitor where userId = :userId")
    List<Object[]> findMonitorTitleListByUserId(@Param(value = "userId") String userId);

}

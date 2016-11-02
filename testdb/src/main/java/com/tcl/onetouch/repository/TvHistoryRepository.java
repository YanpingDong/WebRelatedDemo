package com.tcl.onetouch.repository;

import com.tcl.onetouch.model.TvHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TvHistoryRepository extends JpaRepository<TvHistory, Long> {

    Page<TvHistory> findByUsernameOrderByTimestampDesc(String username, Pageable pageable);

    Page<TvHistory> findByUsername(String username, Pageable pageable);

    TvHistory findByUsernameAndStypeAndVtypeAndMediaId(String username, String stype, String vtype, String mediaId);

    Page<TvHistory> findByUsernameAndTimestampGreaterThanOrderByTimestampDesc(
            String userId, Date startDate, Pageable pageable);

    List<TvHistory> findByUsernameAndTimestampBetween(String userId, Date startDate, Date endDate);

    List<TvHistory> findByUsername(String username);
}

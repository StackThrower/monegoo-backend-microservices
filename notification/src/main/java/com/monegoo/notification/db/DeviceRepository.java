package com.monegoo.notification.db;

import com.monegoo.notification.db.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {

    @Query( "select count(*) > 0 from Device where id = :id and accessToken = :accessToken")
    Boolean isExistByIdAndAccessToken(@Param("id") Integer id, @Param("accessToken") String accessToken);

}

package com.BoraDeCompra.repository;

import com.BoraDeCompra.entity.UserAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAddressRepo extends JpaRepository<UserAddressEntity, Long> {
    List<UserAddressEntity> findByUserEntity_id(Long userId);
}

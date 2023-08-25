package com.BoraDeCompra.repository;

import com.BoraDeCompra.entity.UserAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepo extends JpaRepository<UserAddressEntity, Long> {
}

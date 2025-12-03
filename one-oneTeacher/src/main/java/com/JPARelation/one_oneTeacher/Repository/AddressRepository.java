package com.JPARelation.one_oneTeacher.Repository;

import com.JPARelation.one_oneTeacher.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findAddressById(Integer id);

}

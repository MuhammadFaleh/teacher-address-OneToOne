package com.JPARelation.one_oneTeacher.Service;

import com.JPARelation.one_oneTeacher.Api.ApiException;
import com.JPARelation.one_oneTeacher.DTO.AddressDTO;
import com.JPARelation.one_oneTeacher.DTO.TeacherDTO;
import com.JPARelation.one_oneTeacher.Model.Address;
import com.JPARelation.one_oneTeacher.Model.Teacher;
import com.JPARelation.one_oneTeacher.Repository.AddressRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherService teacherService;

    public List<Address> getAddress(){
        return addressRepository.findAll();
    }

    public void createAddress(AddressDTO addressDTO){
        Address address = convertDtoToAddress(addressDTO);
        addressRepository.save(address);
    }

    public void updateAddress(Integer id, AddressDTO addressDTO){
        Address address = getAddressById(id);
        if(address == null){
            throw new ApiException("address not found");
        }
        address.setArea(addressDTO.getArea());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        address.setStreet(addressDTO.getStreet());
        addressRepository.save(address);
    }

    public void deleteAddress(Integer id){
        Address address = getAddressById(id);
        if(address == null){
            throw new ApiException("address not found");
        }
        addressRepository.delete(address);
    }
    public Address getAddressById(Integer id){
        return addressRepository.findAddressById(id);
    }

    public Address convertDtoToAddress(AddressDTO addressDTO){
        Teacher teacher = teacherService.getTeacherById(addressDTO.getTeacher_id());
        if(teacher == null){
            throw new ApiException("teacher not found");
        }
        return new Address(addressDTO.getTeacher_id(),addressDTO.getArea(),
                addressDTO.getStreet(),addressDTO.getBuildingNumber(), teacher);
    }

}

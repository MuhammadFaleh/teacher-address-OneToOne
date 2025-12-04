package com.JPARelation.one_oneTeacher.Service;

import com.JPARelation.one_oneTeacher.Api.ApiException;
import com.JPARelation.one_oneTeacher.DTO.IN.AddressDTOIN;
import com.JPARelation.one_oneTeacher.Model.Address;
import com.JPARelation.one_oneTeacher.Model.Teacher;
import com.JPARelation.one_oneTeacher.Repository.AddressRepository;
import com.JPARelation.one_oneTeacher.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAddress(){
        return addressRepository.findAll();
    }

    public void createAddress(AddressDTOIN addressDTOIN){
        Address address = convertDtoToAddress(addressDTOIN);
        addressRepository.save(address);
    }

    public void updateAddress(Integer id, AddressDTOIN addressDTOIN){
        Address address = getAddressById(id);
        if(address == null){
            throw new ApiException("address not found");
        }
        address.setArea(addressDTOIN.getArea());
        address.setBuildingNumber(addressDTOIN.getBuildingNumber());
        address.setStreet(addressDTOIN.getStreet());
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

    public Address convertDtoToAddress(AddressDTOIN addressDTOIN){
        Teacher teacher = teacherRepository.findTeacherById(addressDTOIN.getTeacher_id());
        if(teacher == null){
            throw new ApiException("teacher not found");
        }
        return new Address(teacher.getId(), addressDTOIN.getArea(),
                addressDTOIN.getStreet(), addressDTOIN.getBuildingNumber(), teacher);
    }

}

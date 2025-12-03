package com.JPARelation.one_oneTeacher.Controller;

import com.JPARelation.one_oneTeacher.Api.ApiResponse;
import com.JPARelation.one_oneTeacher.DTO.AddressDTO;
import com.JPARelation.one_oneTeacher.Model.Address;
import com.JPARelation.one_oneTeacher.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/get-addresses")
    public ResponseEntity<?> getAddresses(){

        return ResponseEntity.status(200).body(addressService.getAddress());
    }

    @PostMapping("/create-address")
    public ResponseEntity<?> createAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.createAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("address was created successfully"));

    }
    @PutMapping("/update-address/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable Integer id, @RequestBody @Valid AddressDTO addressDTO){
        addressService.updateAddress(id, addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("address was updated successfully"));
    }
    @DeleteMapping("/delete-address/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body(new ApiResponse("address was deleted successfully"));
    }

    @GetMapping("/get-address-id/{id}")
    public ResponseEntity<?> getAddressById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(addressService.getAddressById(id));
    }
}

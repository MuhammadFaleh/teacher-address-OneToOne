package com.JPARelation.one_oneTeacher.Controller;

import com.JPARelation.one_oneTeacher.Api.ApiResponse;
import com.JPARelation.one_oneTeacher.DTO.IN.AddressDTOIN;
import com.JPARelation.one_oneTeacher.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> createAddress(@RequestBody @Valid AddressDTOIN addressDTOIN){
        addressService.createAddress(addressDTOIN);
        return ResponseEntity.status(200).body(new ApiResponse("address was created successfully"));

    }
    @PutMapping("/update-address/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable Integer id, @RequestBody @Valid AddressDTOIN addressDTOIN){
        addressService.updateAddress(id, addressDTOIN);
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

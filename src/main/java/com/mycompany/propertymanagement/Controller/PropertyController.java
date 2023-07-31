package com.mycompany.propertymanagement.Controller;

import com.mycompany.propertymanagement.Service.PropertyService;
import com.mycompany.propertymanagement.dto.PropertyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Value("${property.dummy:}")
    private String dummy;

    @Value("${spring.datasource.url:}")
    private String dbUrl;

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/namasthe")
    public String sayNamasthe() {

        return "Namasthe";
    }

    @PostMapping("/properties")
    public ResponseEntity<PropertyDto> saveProperty(@RequestBody PropertyDto propertyDto) {
        propertyDto = propertyService.saveProperty(propertyDto);

        ResponseEntity<PropertyDto> responseEntity = new ResponseEntity<>(propertyDto, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDto>> getAllProperties() {
        System.out.println(dummy);
        System.out.println(dbUrl);
        List<PropertyDto> propertyList = propertyService.getAllProperties();
        ResponseEntity<List<PropertyDto>> responseEntity = new ResponseEntity<>(propertyList, HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDto> updateProperty(@RequestBody PropertyDto propertyDto, @PathVariable Long propertyId) {
        propertyDto = propertyService.updateProperty(propertyDto, propertyId);
        ResponseEntity<PropertyDto> responseEntity = new ResponseEntity<>(propertyDto, HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/properties/update-description/{propertyId}")
    public ResponseEntity<PropertyDto> updatePropertyDescription(@RequestBody PropertyDto propertyDto,@PathVariable Long propertyId) {
        propertyDto = propertyService.updatePropertyDescription(propertyDto, propertyId);
        ResponseEntity<PropertyDto> responseEntity = new ResponseEntity<>(propertyDto, HttpStatus.OK);
        return responseEntity;

    }

    @PatchMapping("/properties/update-price/{propertyId}")
    public ResponseEntity<PropertyDto> updatePropertyPrice(@RequestBody PropertyDto propertyDto,@PathVariable Long propertyId) {
        propertyDto = propertyService.updatePropertyPrice(propertyDto, propertyId);
        ResponseEntity<PropertyDto> responseEntity = new ResponseEntity<>(propertyDto, HttpStatus.OK);
        return responseEntity;
    }
   @DeleteMapping("/properties/{propertyId}")
   public ResponseEntity deleteProperty(@PathVariable Long propertyId){
        propertyService.deleteProperty(propertyId);
       ResponseEntity<Void> responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
       return responseEntity;
    }
}



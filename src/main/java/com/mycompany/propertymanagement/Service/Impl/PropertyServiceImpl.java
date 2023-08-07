package com.mycompany.propertymanagement.Service.Impl;

import com.mycompany.propertymanagement.Converter.PropertyConverter;
import com.mycompany.propertymanagement.Entity.PropertyEntity;
import com.mycompany.propertymanagement.Repository.PropertyRepository;
import com.mycompany.propertymanagement.Service.PropertyService;
import com.mycompany.propertymanagement.dto.PropertyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {


    @Value("${property.dummy:}")
    private String dummy;

    @Value("${spring.datasource.url:}")
    private String dbUrl;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;
    @Override
    public PropertyDto saveProperty(PropertyDto propertyDto) {

        PropertyEntity pe =propertyConverter.convertDtotoEntity(propertyDto);
        pe=propertyRepository.save(pe);

        propertyDto = propertyConverter.convertEntitytoDto(pe);
        return propertyDto;


    }

    @Override
    public List<PropertyDto> getAllProperties() {

        System.out.println("Inside service" +dummy);
        System.out.println("Inside service" +dbUrl);


       List<PropertyEntity> listofProps = (List<PropertyEntity>)propertyRepository.findAll();
       List<PropertyDto> proplist = new ArrayList<>();

       for (PropertyEntity pe : listofProps){
           PropertyDto dto= propertyConverter.convertEntitytoDto(pe);
           proplist.add(dto);
       }
        return proplist;
    }

    @Override
    public PropertyDto updateProperty(PropertyDto propertyDto, Long propertyId) {

        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        PropertyDto dto = null;
        if (optEn.isPresent()){

            PropertyEntity pe = optEn.get();
            pe.setTitle(propertyDto.getTitle());
            pe.setAddress(propertyDto.getAddress());
            pe.setPrice(propertyDto.getPrice());
            pe.setDescription(propertyDto.getDescription());
            dto = propertyConverter.convertEntitytoDto(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDto updatePropertyDescription(PropertyDto propertyDto, Long propertyId) {
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        PropertyDto dto = null;
        if (optEn.isPresent()){

            PropertyEntity pe = optEn.get();
            pe.setDescription(propertyDto.getDescription());
            dto = propertyConverter.convertEntitytoDto(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDto updatePropertyPrice(PropertyDto propertyDto, Long propertyId) {
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        PropertyDto dto = null;
        if (optEn.isPresent()){

            PropertyEntity pe = optEn.get();
            pe.setPrice(propertyDto.getPrice());
            dto = propertyConverter.convertEntitytoDto(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}

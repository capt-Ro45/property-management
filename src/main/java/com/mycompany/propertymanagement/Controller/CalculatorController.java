package com.mycompany.propertymanagement.Controller;

import com.mycompany.propertymanagement.dto.CalculatorDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")

public class CalculatorController {
    @GetMapping("/add")
    public  Double add(@RequestParam("num1") Double num11, @RequestParam("num2") Double num22){

        return num11+num22;
    }
    @GetMapping("/sub/{num111}/{num2}")
    public Double substract(@PathVariable("num111") Double num1, @PathVariable("num2") Double num2){
        Double result= null;
        if (num1>num2) {
            result = num1 - num2;
        }else {
            result = num2 - num1;
        }

        return result;
    }
    @PostMapping("/mul")
    public Double multiply(@RequestBody CalculatorDto calculatorDto){
        Double result = null;
        result= calculatorDto.getNum1() * calculatorDto.getNum2() * calculatorDto.getNum3() * calculatorDto.getNum4();
        return result;

    }
}

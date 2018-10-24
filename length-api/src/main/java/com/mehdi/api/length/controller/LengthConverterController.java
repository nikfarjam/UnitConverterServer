package com.mehdi.api.length.controller;

import com.mehdi.api.length.model.LengthResponse;
import com.mehdi.api.length.service.LengthConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.mehdi.api.length.LengthUnitConstants.*;

@RestController
@RequestMapping("converter/length/")
public class LengthConverterController {

    private static final Logger logger = LogManager.getLogger(LengthConverterController.class.getName());

    private LengthConverter lengthConverter;

    @Autowired
    public LengthConverterController(LengthConverter lengthConverter) {
        this.lengthConverter = lengthConverter;
    }

    @RequestMapping("meterToFeet")
    public LengthResponse meterToFeet(@RequestParam(value="meter") Double meter,
                                      @RequestParam(value="fraction", defaultValue = "2") Integer fraction) {
        logger.debug("Input meter value is {}",meter);
        if (meter == null) {
            return new LengthResponse(null, UNIT_FEET, MESSAGE_INVALID_INPUT);
        }
        double feet = lengthConverter.meterToFeet(meter, fraction);
        return new LengthResponse(feet, UNIT_FEET, MESSAGE_SUCCESS);
    }
}

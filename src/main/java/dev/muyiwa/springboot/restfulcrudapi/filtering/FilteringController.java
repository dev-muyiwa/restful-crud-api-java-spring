package dev.muyiwa.springboot.restfulcrudapi.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/filters")
public class FilteringController {
    @GetMapping("/")
    public MappingJacksonValue filtering() {
        SomeBean bean = new SomeBean("value 1", "value 2", "value 3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(bean);
        SimpleBeanPropertyFilter beanFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field_1");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", beanFilter);

        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }
}

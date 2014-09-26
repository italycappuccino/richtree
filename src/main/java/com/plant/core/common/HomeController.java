package com.plant.core.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.plant.core.entity.City;
import com.plant.core.service.CountryService;

@Controller
public class HomeController {

    private static final Logger log  = LoggerFactory.getLogger(HomeController.class);
    private static final Gson   gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    @Resource
    private CountryService      countryService;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/demo/country", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public Object queryCountry(HttpServletRequest request, HttpServletResponse response) {
        log.info("queryCountry");
        //response.setContentType("text/html;charset=utf-8");
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            String country = request.getParameter("country");
            City city = new City();
            city.setCountryCode(country);
            log.info("condition=" + gson.toJson(city));
            Long count = countryService.countCountryByCondition(city);
            List<City> list = countryService.listCityByCondition(city);
            map.put("city", list);
            map.put("count", count);
            map.put("success", Boolean.TRUE);
        } catch (Exception e) {
            map.put("success", Boolean.FALSE);
            map.put("Msg", e.getMessage());
            log.error("query failed. errorMsg=" + e.getMessage());
        }
        log.info("result=" + gson.toJson(map));
        return gson.toJson(map);
    }
}

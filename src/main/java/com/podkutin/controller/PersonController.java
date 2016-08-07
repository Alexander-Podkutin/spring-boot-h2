package com.podkutin.controller;

import com.podkutin.view.PersonVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by apodkutin on 8/7/16.
 */

@RestController
public class PersonController {

    private static final List<PersonVO> persons =
            Arrays.asList(new PersonVO(1l, "Alex Smith", 33), new PersonVO(2l, "John Brown", 15), new PersonVO(3l, "Ben Wilson", 50),
                    new PersonVO(0l, "Noname", 0));

    @RequestMapping("/person")
    public PersonVO getPerson(@RequestParam(value="fullName", defaultValue = "Noname") String fullName) {


        List<PersonVO> resultPerson = persons.stream().filter(
                p -> fullName.equals(p.getFullName())).collect(Collectors.toList());

        return !resultPerson.isEmpty() ? resultPerson.get(0) : null;


    }
}

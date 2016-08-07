package com.podkutin.controller;

import com.podkutin.exception.ResourceNotFound;
import com.podkutin.view.PersonVO;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;

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
                p -> fullName.equalsIgnoreCase(p.getFullName())).collect(Collectors.toList());

        if (!resultPerson.isEmpty()) {
            return resultPerson.get(0);
        } else {
            throw new ResourceNotFound();
        }


    }

}

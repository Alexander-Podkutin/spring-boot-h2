package com.podkutin.controller;

import com.podkutin.exception.ResourceNotFound;
import com.podkutin.view.ClientVO;
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

    private static final List<ClientVO> persons =
            Arrays.asList(new ClientVO(1l, "alex.smith@gmail.com", "Alex", "Smith", null),
                    new ClientVO(2l, "john.brown@gmail.com", "John", "Brown", null),
                    new ClientVO(3l, "ben.wilson@gmail.com", "Ben", "Wilson", null),
                    new ClientVO(0l, "noname", "Noname", "Noname", null));

    @RequestMapping("/person")
    public ClientVO getPerson(@RequestParam(value="login", defaultValue = "noname") String login) {
        List<ClientVO> resultPerson = persons.stream().filter(
                p -> login.equalsIgnoreCase(p.getLogin())).collect(Collectors.toList());

        if (!resultPerson.isEmpty()) {
            return resultPerson.get(0);
        } else {
            throw new ResourceNotFound();
        }


    }

}

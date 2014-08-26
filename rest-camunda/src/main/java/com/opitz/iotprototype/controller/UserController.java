package com.opitz.iotprototype.controller;

import com.opitz.iotprototype.entities.NetworkNode;
import com.opitz.iotprototype.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * {@link User} controller.
 * <p/>
 * User: Pascal Date: 03.09.13 Time: 22:06
 */

@Controller
@RequestMapping("/service/users")
public class UserController {

    /**
     * Set current state of a certain {@link User} by starting a new process instance.
     * <p/>
     * <p/>
     * <pre>
     * <b>REST call example:</b><br/>
     * {@code PUT .../users/<exampleUsername>/state/<exampleState>}<br/>
     * and {@link User} as {@link RequestBody}
     * </pre>
     *
     * @param username unique user name
     * @param state    expected states: online or offline
     * @return process instance id
     */
    @ResponseBody
    @RequestMapping(value = "/{username}/state/{setState}", method = RequestMethod.PUT)
    public String setUserState(@PathVariable("username") String username,
                               @PathVariable("setState") String state) {
        return "User " + username + "now is " + state;
    }

    /**
     * Create a new {@link User}.
     * <p/>
     * Please note that when adding a new user via rest, there must be a network node supplied with the user. so first
     * fetch all network nodes from the api, then select the one that should be the one that the user usually carries on
     * him (a smartphone e.g.) and then add the user with this method.
     * <p/>
     * <p/>
     * <pre>
     * <b>REST call example:</b><br/>
     * {@code POST .../users}<br/>
     * and {@link User} as {@link RequestBody}
     * </pre>
     *
     * @param user new {@link User}
     * @return created {@link User}
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public User create(@RequestBody User user) {

        //later in the service, the user will get an ID and this is a dummy ID
        user.setId(42);
        return user;
    }

    /**
     * Update a {@link User}.
     * <p/>
     * <p/>
     * <pre>
     * <b>REST call example:</b><br/>
     * {@code PUT .../users<br/>
     * and {@link User} as {@link RequestBody}
     * </pre>
     *
     * @param user {@link User} with new values
     * @return updated {@link User}
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public User update(@RequestBody User user) {

        //just returning the user again, later, the service will first update the ressource in the DB and then return the saved value
        return user;
    }

    /**
     * Delete {@link User} by user name.
     * <p/>
     * <p/>
     * <pre>
     * <b>REST call example:</b><br/>
     * {@code DELETE .../users/<exampleUserID>}
     * </pre>
     *
     * @param userID userID
     * @return true if deletion successful, otherwise false
     */
    @ResponseBody
    @RequestMapping(value = "/{userID}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("userID") Integer userID) {
        return true;
    }

    /**
     * Retrieve all {@link User}.
     * <p/>
     * <p/>
     * <pre>
     * <b>REST call example:</b><br/>
     * {@code GET .../users}
     * </pre>
     *
     * @return {@link List} of {@link User}
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAll() {

        //creating some dummy values
        List<User> list = new ArrayList<>();
        User dummy = new User();
        dummy.setId(42);
        dummy.setPersonalDevice(new NetworkNode("FF:FF:FF:FF:FF:FF", "iottestphone", "192.168.1.101"));
        dummy.setUsername("iotTestUser");
        list.add(dummy);
        return list;
    }

    /**
     * Retrieve all user MAC address (devices).
     * <p/>
     * <p/>
     * <pre>
     * <b>REST call example:</b><br/>
     * {@code GET .../users/devices}
     * </pre>
     *
     * @return {@link HashMap} of form Entry(MacAddress, Username)
     */
    @ResponseBody
    @RequestMapping(value = "/devices", method = RequestMethod.GET)
    public HashMap<String, String> getAllDevices() {
        HashMap<String, String> sampleMap = new HashMap<>();
        sampleMap.put("FF:FF:FF:FF:FF:FF", "iotTestUser");
        return sampleMap;
    }

    /**
     * Retrieve {@link User} by user name.
     * <p/>
     * <p/>
     * <pre>
     * <b>REST call example:</b><br/>
     * {@code GET .../users/username/<exampleUserName>}
     * </pre>
     *
     * @param username user name
     * @return {@link User}
     */
    @ResponseBody
    @RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
    public User findByUsername(@PathVariable("username") String username) {
        User dummy = new User();
        dummy.setId(42);
        dummy.setPersonalDevice(new NetworkNode("FF:FF:FF:FF:FF:FF", "iottestphone", "192.168.1.101"));
        dummy.setUsername("iotTestUser");
        return dummy;
    }

}

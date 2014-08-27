package com.opitz.iotprototype.controller;

import com.opitz.iotprototype.entities.User;
import com.opitz.iotprototype.entities.UserState;
import com.opitz.iotprototype.services.NetworkNodeService;
import com.opitz.iotprototype.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    NetworkNodeService networkNodeService;

    @Autowired
    UserService userService;

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
     * @return updated user resource
     */
    @ResponseBody
    @RequestMapping(value = "/{username}/state/{setState}", method = RequestMethod.PUT)
    public User setUserState(@PathVariable("username") String username,
                               @PathVariable("setState") UserState state) {
        User user = userService.load(username);
        user.setState(state);
        userService.save(user);
        return user;

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
        userService.save(user);
        return userService.load(user.getUsername());
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
        userService.update(user);
        return userService.load(user.getId());
    }

    /**
     * Delete {@link User} by user name.
     * <p/>
     * <p/>
     * <pre>
     * <b>REST call example:</b><br/>
     * {@code DELETE .../users/<exampleUserName>}
     * </pre>
     *
     * @param userID user id
     * @return true if deletion successful, otherwise false
     */
    @ResponseBody
    @RequestMapping(value = "/{userID}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("userID") Integer userID) {
        User user = userService.load(userID);
        try {
            userService.delete(user);
            return true;
        } catch (Exception e) {
            return false; // TODO change return type to {@link HttpServletResponse}
        }
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
        return userService.listAll();
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
        return userService.getDeviceMACUserMap();
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
        return userService.load(username);
    }

}

package com.opitz.iotprototype.controller;

import com.opitz.iotprototype.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

/**
 * {@link User} controller.
 * 
 * User: Pascal Date: 03.09.13 Time: 22:06
 */

@Controller
@RequestMapping("/service/users")
public class UserController {

	/**
	 * Set current state of a certain {@link User} by starting a new process
	 * instance.
	 * <p>
	 * S
	 * <pre>
	 * <b>REST call example:</b><br/>
	 * {@code PUT .../users/<exampleUsername>/state/<exampleState>}<br/>
	 * and {@link User} as {@link RequestBody}
	 * </pre>
	 * 
	 * @param username
	 *          unique user name
	 * @param state
	 *          expected states: online or offline
	 * @return process instance id
	 */

	public String setUserState(String username, String state) {
		return null;
	}

	/**
	 * Create a new {@link User}.
	 * <p>
	 * Please note that when adding a new user via rest, there must be a network
	 * node supplied with the user. so first fetch all network nodes from the api,
	 * then select the one that should be the one that the user usually carries on
	 * him (a smartphone e.g.) and then add the user with this method.
	 * <p>
	 * 
	 * <pre>
	 * <b>REST call example:</b><br/>
	 * {@code POST .../users}<br/>
	 * and {@link User} as {@link RequestBody}
	 * </pre>
	 * 
	 * @param user
	 *          new {@link User}
	 * 
	 * @return created {@link User}
	 */

	public User create(User user) {
		return null;
	}

	/**
	 * Update a {@link User}.
	 * <p>
	 * 
	 * <pre>
	 * <b>REST call example:</b><br/>
	 * {@code PUT .../users<br/>
	 * and {@link User} as {@link RequestBody}
	 * </pre>
	 * 
	 * @param user
	 *          {@link User} with new values
	 * 
	 * @return updated {@link User}
	 */

	public User update(User user) {
	return null;
	}

	/**
	 * Delete {@link User} by user id.
	 * <p>
	 * 
	 * <pre>
	 * <b>REST call example:</b><br/>
	 * {@code DELETE .../users/<exampleUserID>}
	 * </pre>
	 * 
	 * @param userID
	 *          user id
	 * 
	 * @return true if deletion successful, otherwise false
	 */
	public boolean delete(Integer userID) {
		return false;
	}

	/**
	 * Retrieve all {@link User}.
	 * <p>
	 * 
	 * <pre>
	 * <b>REST call example:</b><br/>
	 * {@code GET .../users}
	 * </pre>
	 * 
	 * @return {@link List} of {@link User}
	 */
	public List<User> getAll() {
		return null;
	}

	/**
	 * Retrieve all user MAC address (devices).
	 * <p>
	 * 
	 * <pre>
	 * <b>REST call example:</b><br/>
	 * {@code GET .../users/devices}
	 * </pre>
	 * 
	 * @return {@link HashMap} of form Entry(MacAddress, Username)
	 */

	public HashMap<String, String> getAllDevices() {
		return null;
	}

	/**
	 * Retrieve {@link User} by user name.
	 * <p>
	 * 
	 * <pre>
	 * <b>REST call example:</b><br/>
	 * {@code GET .../users/username/<exampleUserName>}
	 * </pre>
	 * 
	 * 
	 * @param username
	 *          user name
	 * 
	 * @return {@link User}
	 */

	public User findByUsername(String username) {
		return null;
	}

}

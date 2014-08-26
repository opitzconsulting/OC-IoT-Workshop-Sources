package com.opitz.iotprototype.controller;

import com.opitz.iotprototype.entities.ElroPowerPlug;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * This Controller manages all switch interaction, so basically on and off
 * adding deleting and querying.
 * <p>
 * User: Pascal Date: 07.10.13 Time: 12:31
 */

@Controller
@RequestMapping("/service/switches")
public class SwitchController {

	/**
	 * Activate a certain {@link ElroPowerPlug}.
	 * <p>
	 * 
	 * <pre>
	 * <b>REST call example:</b><br/>
	 * {@code PUT .../switches/activate/<exampleId><br/>
	 * </pre>
	 * 
	 * @param id
	 *            certain {@link ElroPowerPlug} id
	 * @return certain {@link ElroPowerPlug} retreived from the DB after
	 *         updating the lastKnownState
	 */
	public ElroPowerPlug activate(Integer id) {
		return null;
	}

	/**
	 * Deactivate a certain {@link ElroPowerPlug}.
	 * <p>
	 * 
	 * <pre>
	 * <b>REST call example:</b><br/>
	 * {@code PUT .../switches/deactivate/<exampleId><br/>
	 * </pre>
	 * 
	 * @param id
	 *            certain {@link ElroPowerPlug} id
	 * @return certain {@link ElroPowerPlug} retreived from the DB after
	 *         updating the lastKnownState
	 */

	public ElroPowerPlug deactivate(Integer id) {
		return null;
	}

	/**
	 * Retrieve all {@link ElroPowerPlug}s. (TODO available to the requesting user
	 * <p>
	 * 
	 * <pre>
	 * <b>REST call example:</b><br/>
	 * {@code GET .../switches}
	 * </pre>
	 * 
	 * @return {@link List} of {@link ElroPowerPlug}
	 */
	public List<ElroPowerPlug> getAll() {
		return null;
	}

	/**
	 * Create a new {@link ElroPowerPlug}.
	 * <p>
	 * 
	 * <pre>
	 * <b>REST call example:</b><br/>
	 * {@code POST .../switches}<br/>
	 * and {@link ElroPowerPlug} as {@link RequestBody}
	 * </pre>
	 * 
	 * @param newPlug
	 *            new {@link ElroPowerPlug}
	 * 
	 * @return created {@link ElroPowerPlug}
	 */

	public ElroPowerPlug create(ElroPowerPlug newPlug) {
		return null;
	}

	/**
	 * Delete {@link ElroPowerPlug} by id from system.
	 * <p>
	 * 
	 * <pre>
	 * <b>REST call example:</b><br/>
	 * {@code DELETE .../switches/<exampleId>}
	 * </pre>
	 * 
	 * @param id
	 *            unique {@link ElroPowerPlug} identifier
	 *
	 */
	public void delete(Integer id){

	}

}

package com.opitz.iotprototype.controller;

import com.opitz.iotprototype.entities.ElroPowerPlug;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @ResponseBody
    @RequestMapping(value = "/activate/{id}", method = RequestMethod.PUT)
    public ElroPowerPlug activate(@PathVariable("id") Integer id) {
        ElroPowerPlug dummy = new ElroPowerPlug();
        dummy.setId(42);
        dummy.setLabel("testPlug");
        dummy.setGroupID("01011");
        dummy.setSwitchID("01101");
        dummy.setLastKnownState(true);
        return dummy;

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
    @ResponseBody
    @RequestMapping(value = "/deactivate/{id}", method = RequestMethod.PUT)
    public ElroPowerPlug deactivate(@PathVariable("id") Integer id) {
        ElroPowerPlug dummy = new ElroPowerPlug();
        dummy.setId(42);
        dummy.setLabel("testPlug");
        dummy.setGroupID("01011");
        dummy.setSwitchID("01101");
        dummy.setLastKnownState(false);
        return dummy;
    }

    /**
     * Retrieve all {@link ElroPowerPlug}s. (TODO available to the requesting
     * user)
     * <p>
     *
     * <pre>
     * <b>REST call example:</b><br/>
     * {@code GET .../switches}
     * </pre>
     *
     * @return {@link List} of {@link ElroPowerPlug}
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<ElroPowerPlug> getAll() {
        List<ElroPowerPlug> dummyList = new ArrayList<>();

        ElroPowerPlug dummy = new ElroPowerPlug();
        dummy.setId(42);
        dummy.setLabel("testPlug");
        dummy.setGroupID("01011");
        dummy.setSwitchID("01101");
        dummy.setLastKnownState(true);

        dummyList.add(dummy);
        return dummyList;
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
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ElroPowerPlug create(@RequestBody ElroPowerPlug newPlug) {
        newPlug.setId(42);
        return newPlug;
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
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id){
    }

}

package com.opitz.iotprototype.services;

import com.opitz.iotprototype.daos.ElroPowerPlugDAO;
import com.opitz.iotprototype.entities.ElroPowerPlug;
import com.opitz.iotprototype.utils.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * User: Pascal
 * Date: 07.01.14
 * Time: 15:45
 */

@Service
public class ElroPowerPlugServiceImpl implements ElroPowerPlugService {

    @Autowired
    private ElroPowerPlugDAO elroPowerPlugDAO;

    @Transactional
    @Override
    public ElroPowerPlug setState(ElroPowerPlug elroPowerPlug, boolean state) {

        return null;

    }

    @Transactional
    @Override
    public ElroPowerPlug setState(Integer id, boolean state) {
        return this.setState(elroPowerPlugDAO.load(id), state);
    }

    @Transactional
    @Override
    public Serializable save(ElroPowerPlug elroPowerPlug) {
        if(elroPowerPlug.getId() == null){
            return elroPowerPlugDAO.save(elroPowerPlug);
        }
        elroPowerPlugDAO.update(elroPowerPlug);
        return elroPowerPlug.getId();
    }

    @Transactional
    @Override
    public void delete(Integer id) throws DataNotFoundException {
        elroPowerPlugDAO.delete(elroPowerPlugDAO.load(id));
    }

    @Transactional
    @Override
    public List<ElroPowerPlug> findByLabel(String label) {
        return elroPowerPlugDAO.findByLabel(label);
    }

    @Override
    @Transactional
    public ElroPowerPlug load(Serializable id) {
        return elroPowerPlugDAO.load(id);
    }

    @Transactional
    @Override
    public List<ElroPowerPlug> listAll() {
        return elroPowerPlugDAO.listAll();
    }
}

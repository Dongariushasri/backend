package com.main.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.main.entity.Pmanager;
@Service
public interface Pmanagerservice {
    Pmanager registerPmanager(Pmanager pmanager);
    Pmanager loginPmanager(String email, String password);
    Pmanager updatePmanager(Pmanager updatedPmanager);
    Pmanager getById(Integer Pmanager);
    void deleteProjectManager(Integer id);
    public List<Pmanager> getallPmanagers();
}

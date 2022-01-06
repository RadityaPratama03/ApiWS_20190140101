/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pws.ti.Jajanan.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pws.ti.Jajanan.entity.Barang;
import pws.ti.Jajanan.repository.JajananRepository;
/**
 *
 * @author Swift3
 */
@Service
public class JajananServiceImpl implements JajananService{
    @Autowired
    private JajananRepository repository;
    @Override
    public Barang addBarang(Barang jajan) {
      return repository.save(jajan);
    }
    @Override
    public Barang getBarangById(int jajanId) {
      return repository.findById(jajanId).get();
    }
    @Override
    public List<Barang> getAllBarang(){
      return repository.findAll();
    }

    @Override
    public void updateBarang(Barang jajan) {
      Barang jajanDB = repository.findById(jajan.getId()).orElseThrow();
      repository.save(jajan);
    }

    @Override
    public void deleteBarangById(int jajanId) {
      try {
        repository.deleteById(jajanId);  
      }
      catch(Exception ex){
        throw new RuntimeException(ex.getMessage());
      }
    }
}

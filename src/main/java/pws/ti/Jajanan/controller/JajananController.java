/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pws.ti.Jajanan.controller;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import pws.ti.Jajanan.service.JajananService;
import pws.ti.Jajanan.entity.Barang;

@CrossOrigin
@RestController
@RequestMapping("/jajanan")
public class JajananController {
    
    @Autowired
    JajananService jajananService;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Barang addBarang(@RequestBody Barang jajan) {
      return jajananService.addBarang(jajan);
    }
    // Fetch all user records
    @GetMapping
    public List<Barang> getAllBarang(){
      return jajananService.getAllBarang();
    }
    // Fetch single user
    @GetMapping("/{id}")
    public Barang getBarangById(@PathVariable("id") int jajanId){
      return jajananService.getBarangById(jajanId);
    }
    // Update user record
    @PutMapping("/updatebarang")
    public ResponseEntity<String> updateBarang(@RequestBody Barang jajan) {  
      try {
        jajananService.updateBarang(jajan);
        return new ResponseEntity<String>(HttpStatus.OK);
      }catch(NoSuchElementException ex){
        // log the error message
        System.out.println(ex.getMessage());
        return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
      }
    }
    // Delete user record
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
    try {
        jajananService.deleteBarangById(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    catch(RuntimeException ex){
      // log the error message
      System.out.println(ex.getMessage());
      return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
    }
  }
}

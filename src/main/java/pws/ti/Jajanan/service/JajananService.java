/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pws.ti.Jajanan.service;

import java.util.List;
import pws.ti.Jajanan.entity.Barang;

public interface JajananService {
    
    Barang addBarang(Barang jajan);
    Barang getBarangById(int jajanId);
    void updateBarang(Barang jajan);
    void deleteBarangById(int jajanId);
    List<Barang> getAllBarang();
}

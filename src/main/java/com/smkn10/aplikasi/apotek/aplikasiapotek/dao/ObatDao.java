package com.smkn10.aplikasi.apotek.aplikasiapotek.dao;

import com.smkn10.aplikasi.apotek.aplikasiapotek.entity.Obat;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObatDao extends PagingAndSortingRepository<Obat, String> {

}

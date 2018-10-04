package com.smkn10.aplikasi.apotek.aplikasiapotek.controller;

import com.smkn10.aplikasi.apotek.aplikasiapotek.dao.ObatDao;
import com.smkn10.aplikasi.apotek.aplikasiapotek.entity.Obat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping(value = "/obat")
public class ObatController {

    @Autowired
    private ObatDao obatDao;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("listObat", obatDao.findAll());
        return "list";
    }

    @PostMapping("/saveForm")
    public String saveForm(Obat obat) {
        obatDao.save(obat);
        return "redirect:/obat/list";
    }

    @GetMapping("/deleteObat")
    public String deleteObat(@RequestParam("id") String id) {
        Optional<Obat> opObat = obatDao.findById(id);
        if (opObat.isPresent()) {
            obatDao.delete(opObat.get());
        }
        return "redirect:/obat/list";
    }

    @GetMapping("/form")
    public String showForm(Model model, @RequestParam(required = false) String id) {
        Obat m = new Obat();
        if (id != null) {
            Optional<Obat> opObat = obatDao.findById(id);
            if (opObat.isPresent()) {
                m = opObat.get();
            }
        }
        model.addAttribute("obat", m);
        return "form";
    }
}

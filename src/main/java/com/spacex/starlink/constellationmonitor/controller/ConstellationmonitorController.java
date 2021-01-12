/**
 * ============================================================
 * Created by  - Pramoj Kumararathna
 * On          - Jan 03, 2021
 * At          - 12:08 AM
 * ============================================================
 */
package com.spacex.starlink.constellationmonitor.controller;

import com.spacex.starlink.constellationmonitor.model.Satellite;
import com.spacex.starlink.constellationmonitor.service.ConstellationMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/constellationmonitor")
public class ConstellationmonitorController {

    private String appMode;

    @Autowired
    public ConstellationmonitorController(Environment environment) {
        appMode = environment.getProperty("app-mode");
    }

    @Autowired
    ConstellationMonitorService constellationMonitorService;

    public Iterable list;

    @GetMapping(value = "/fetch")
    @ResponseBody
    public List<Satellite> fetchConstellations() {
        return constellationMonitorService.fetchConstellation();
    }

    @PostMapping(value = "/add")
    public String addConstellations() {
        constellationMonitorService.addSatellite();
        return "Successfully added !";
    }

    @GetMapping(value = "/greet")
    public String greeting(Model model) {
        list = constellationMonitorService.fetchConstellation();
        model.addAttribute("list", list);
        return "index";
    }

    @RequestMapping("/dashboard")
    public String index(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("datetime", new Date());

        list = constellationMonitorService.fetchAll(page);

        model.addAttribute("list", list);
        model.addAttribute("currentPage", page);

        return "index";
    }

    @GetMapping("/findSatellite")
    @ResponseBody
    public Satellite getById(Long id) {
        return constellationMonitorService.getById(id);
    }

    @RequestMapping("/save")
    public String saveSatellite(Satellite satellite) {
        constellationMonitorService.save(satellite);
        return "redirect:dashboard";
    }

    @GetMapping("/delete")
    public String deleteSatellite(Long id) {
        constellationMonitorService.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/assign")
    public String assign(Long id) {
        constellationMonitorService.assign(id);
        return "redirect:/constellationmonitor/dashboard";
    }

    @RequestMapping("/unassign")
    public String unAssign(Long id) {
        constellationMonitorService.unassign(id);
        return "redirect:/constellationmonitor/dashboard";
    }

}

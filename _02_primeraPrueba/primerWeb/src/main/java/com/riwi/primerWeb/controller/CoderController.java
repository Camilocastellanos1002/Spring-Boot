package com.riwi.primerWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.riwi.primerWeb.entity.Coder;
import com.riwi.primerWeb.services.CoderService;

//declarar que es tipo controlador
@Controller
@RequestMapping("/")
public class CoderController {

    @Autowired
    private CoderService obCoderService;

    /*
     * Metodo para mostrar la vista y enviarle la lista coders
     */
    @GetMapping
    //recibe el modelo 
    public String showViewGetAll(Model objModel){

        List<Coder> list= this.obCoderService.findAll();    //genera una lista los coders que recibe del servicio
        System.out.println(list);
        objModel.addAttribute("coderList", list);

        //se debe retornar el nombre exacto de la vista html
        return "viewCoder";
    }

    @RequestMapping("/Form")
    public String showViewFormCoder(){
        return "ViewForm";
    }

}

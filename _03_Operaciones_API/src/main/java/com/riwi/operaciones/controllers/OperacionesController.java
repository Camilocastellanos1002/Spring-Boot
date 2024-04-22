package com.riwi.operaciones.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.operaciones.entities.Operaciones;

@RestController
@RequestMapping("/api/v1/operaciones")
public class OperacionesController {
    
    @PostMapping(path = "/add")
    public String add (@RequestBody Operaciones objOperaciones){
        String mensaje = String.valueOf(objOperaciones.getNum1()+ objOperaciones.getNum2());

        return objOperaciones.getNum1() + " + " + objOperaciones.getNum2()+" = "+mensaje;
    }

    @PostMapping(path="/rest")
    public String rest(@RequestBody Operaciones objOperaciones){
        String mensaje = String.valueOf(objOperaciones.getNum1() - objOperaciones.getNum2());

        return objOperaciones.getNum1() + " - " + objOperaciones.getNum2()+" = "+mensaje;
    }

    @PostMapping(path = "/div")
    public String div(@RequestBody Operaciones objOperaciones){

        if (objOperaciones.getNum2() ==0) {
            return "No se puede dividir por cero";
        }
        String mensaje = String.valueOf(objOperaciones.getNum1() / objOperaciones.getNum2());

        return objOperaciones.getNum1() + " / " + objOperaciones.getNum2()+" = "+mensaje;
    }

    @PostMapping(path = "/multiplication")
    public String multiply(@RequestBody Operaciones objOperaciones){
        String mensaje = String.valueOf(objOperaciones.getNum1() * objOperaciones.getNum2());

        return objOperaciones.getNum1() + " * " + objOperaciones.getNum2()+" = "+mensaje;
    }

    @PostMapping(path = "/pow")
    public String pow(@RequestBody Operaciones objOperaciones){
        String mensaje = String.valueOf(Math.pow(objOperaciones.getNum1(), objOperaciones.getNum2()));
        
        return objOperaciones.getNum1() + " ^  " + objOperaciones.getNum2()+" = "+mensaje;
    }

    @PostMapping(path = "/residuo")
    public String residue(@RequestBody Operaciones objOperaciones){
        String mensaje = String.valueOf(objOperaciones.getNum1() % objOperaciones.getNum2());

        return objOperaciones.getNum1() + " % " + objOperaciones.getNum2()+" = "+mensaje;
    }


}

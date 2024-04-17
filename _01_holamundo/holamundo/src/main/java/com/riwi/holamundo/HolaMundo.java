package com.riwi.holamundo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;



//crear anotacion y/o frijol que indica que esta clase sera un controlador
@Controller
//RequestMapping crea la ruta base del controlador
@RequestMapping("/controller")
public class HolaMundo {

    //GetMapping crea una ruta especifica para el metodo
    @GetMapping("/holamundo")
    //ResponseBody permite responder en el navegador
    @ResponseBody
    public String mostrarMensaje(){
        return "Hola mundo";
    }

    @GetMapping("/suma")
    @ResponseBody
    public String suma(){
        int a=4;
        int b=399;
        return String.valueOf(a+b);
    }

}

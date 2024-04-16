package com.riwi.holamundo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



//crear anotacion y/o frijol que indica que esta clase sera un controlador
@Controller
//RequestMapping crea la ruta base del controlador
@RequestMapping("/controller")
public class HolaMundo {

    //GetMapping crea una ruta especifica para el metodo
    @GetMapping("/holamundo")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    public String mostrarMensaje(){
        return "Hola mundo";
    }

}

package com.riwi.holamundo;

import org.springframework.stereotype.Controller;

//crear anotacion y/o frijol
@Controller
public class HolaMundo {

    public String mostrarMensaje(){
        return "Hola mundo";
    }

}

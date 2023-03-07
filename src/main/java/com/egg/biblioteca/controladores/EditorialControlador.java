
package com.egg.biblioteca.controladores;

import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.servicios.EditorialServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/editorial")
public class EditorialControlador {

    @Autowired
    private EditorialServicio editorialServicio;
    
    @GetMapping("/registrar")
    public String registrar(){
        return "editorial_form.html";
    }
    
    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, ModelMap modelo){
        
        try {
            editorialServicio.crearEditorial(nombre);
            modelo.put("Exito", "La Editorial fue registrada OK!");
        } catch (MiException ex) {
            modelo.put("Error", ex.getMessage());
            return "editorial_form.html";
        }
        
        return "index.html";
    
    }

}

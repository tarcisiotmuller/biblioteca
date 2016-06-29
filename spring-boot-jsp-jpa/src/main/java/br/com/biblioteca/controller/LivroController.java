package br.com.biblioteca.controller;

import br.com.biblioteca.model.Livro;
import br.com.biblioteca.service.LivroService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LivroController {

    @Autowired
    LivroService service;

    @Autowired
    MessageSource messageSource;

    /*
     * This method will list all existing livros.
     */
    @RequestMapping(value = {"/livros"}, method = RequestMethod.GET)
    public String listLivros(ModelMap model) {

        List<Livro> livros = service.findAll();
        model.addAttribute("livros", livros);
        return "livros";
    }

    /*
     * This method will provide the medium to add a new livro.
     */
    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String newLivro(ModelMap model) {
        Livro livro = new Livro();
        livro.setAnoedicao(2000);
        livro.setClassificacao(10);
        livro.setEscritor("escritor");
        livro.setNome("livro");
        service.save(livro);
        
        model.addAttribute("livro", livro);
        model.addAttribute("edit", false);
        return "cadlivro";
    }

    /*
     * This method will be called on form submission, handling POST request for
     * saving livro in database. It also validates the user input
     */
    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String saveLivro(@Valid Livro livro, BindingResult result,
            ModelMap model) {

        if (result.hasErrors()) {
            return "cadlivro";
        }

        /*
         * Preferred way to achieve uniqueness of field [id] should be implementing custom @Unique annotation 
         * and applying it on field [id] of Model class [Livro].
         * 
         * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
         * framework as well while still using internationalized messages.
         * 
         */
        
        service.save(livro);

        model.addAttribute("success", "Livro " + livro.getNome() + " registered successfully");
        return "success";
    }

    /*
     * This method will provide the medium to update an existing livro.
     */
    @RequestMapping(value = {"/edit-{id}-livro"}, method = RequestMethod.GET)
    public String editLivro(@PathVariable long id, ModelMap model) {
        Livro livro = service.findById(id);
        model.addAttribute("livro", livro);
        model.addAttribute("edit", true);
        return "cadlivro";
    }

    /*
     * This method will be called on form submission, handling POST request for
     * updating livro in database. It also validates the user input
     */
    @RequestMapping(value = {"/edit-{id}-livro"}, method = RequestMethod.POST)
    public String updateLivro(@Valid Livro livro, BindingResult result,
            ModelMap model, @PathVariable long id) {

        if (result.hasErrors()) {
            return "cadlivro";
        }

        service.update(livro);

        model.addAttribute("success", "Livro " + livro.getNome() + " updated successfully");
        return "success";
    }

    /*
     * This method will delete an livro by it's SSN value.
     */
    @RequestMapping(value = {"/delete-{id}-livro"}, method = RequestMethod.GET)
    public String deleteLivro(@PathVariable long id) {
        service.delete(id);
        return "redirect:/livros";
    }
}

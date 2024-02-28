package soa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import soa.entities.Categorie;
import soa.entities.Produit;
import soa.repository.CategorieRepository;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:4200" )
@RequestMapping("/categoris")
public class CategorierRESTController {
    @Autowired
    private CategorieRepository catRepository;
    @GetMapping(value = "/",
    produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Categorie> getAllCategoris(){
     return catRepository.findAll();
    }
    @GetMapping(value = "/getprod/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Collection<Produit> getProduitParCategorieId(@PathVariable Long id){
        //List<Produit> lp = null;
        Categorie c=catRepository.getById(id);
        Collection<Produit> lc= c.getProduits();
        return  lc;
        /*for(Produit p:lc){
            lp.add(p);

        }*/
    // return lp;

    }
}

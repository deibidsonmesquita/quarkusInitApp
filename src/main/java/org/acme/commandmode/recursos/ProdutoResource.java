/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acme.commandmode.recursos;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.acme.commandmode.dto.CadastroProdutoDTO;
import org.acme.commandmode.model.Produto;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

/**
 *
 * @author deibi
 */
@Path("produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @GET
    public List<Produto> listaAll() {
        return Produto.listAll();
    }

    @POST
    @Transactional
    public void salva(CadastroProdutoDTO dto) {
        Produto p = new Produto();
        p.setNome(dto.nome);
        p.setValor(dto.valor);

        p.persist();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public void update(@PathParam("id") Long id, CadastroProdutoDTO dto) {
        Optional<Produto> p = Produto.findByIdOptional(id);

        if (p.isPresent()) {
            Produto produto = p.get();
            produto.setNome(dto.nome);
            produto.setValor(dto.valor);
            produto.persist();
        } else {
            throw new NotFoundException();
        }
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        Optional<Produto> p = Produto.findByIdOptional(id);
        p.ifPresentOrElse(Produto::delete, () -> {
            throw new NotFoundException();
        }
        );
    }
}
